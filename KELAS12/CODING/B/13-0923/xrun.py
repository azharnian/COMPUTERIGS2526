from flask import Flask, render_template, request, redirect, url_for
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

from werkzeug.security import generate_password_hash,\
                              check_password_hash

from forms import LoginForm, ResetForm

import os
from dotenv import load_dotenv
from datetime import datetime

load_dotenv()

app = Flask(__name__)
app.config["SQLALCHEMY_DATABASE_URI"] = os.getenv("DB_URI")
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False
app.config["SECRET_KEY"] = "THIS IS SECRET"

db = SQLAlchemy(app)
migrate = Migrate(app, db)

# Tables or Models

class User(db.Model):
    __tablename__ = "users"
    id          = db.Column(db.Integer, primary_key=True)
    username    = db.Column(db.String(32), nullable=False, index=True)
    password    = db.Column(db.String(256), nullable=False)
    email       = db.Column(db.String(128), nullable=False, index=True)
    created_at  = db.Column(db.DateTime, default=datetime.utcnow, nullable=False)


class Student(db.Model):
    __tablename__ = "students"
    id          = db.Column(db.Integer, primary_key=True)
    nisn        = db.Column(db.String(32), nullable=False, index=True)
    fullname    = db.Column(db.String(128), nullable=False, index=True)
    created_at  = db.Column(db.DateTime, default=datetime.utcnow, nullable=False)


@app.route("/", methods=["GET", "POST"])
def index():
    errors = []
    success = False
    if request.method == "POST":
        username = request.form.get("username")
        email = request.form.get("email")
        password = request.form.get("password")
        retype_password = request.form.get("retype_password")

        if len(username) < 5:
            errors.append("Username must 5 len char or more")
        
        if User.query.filter_by(username=username).first() :
            errors.append("Username already exists")
        
        if User.query.filter_by(email=email).first():
            errors.append("Email already registered")

        if not errors and password == retype_password:
            hash = generate_password_hash(password)
            
            new_user = User(username=username, email=email, password=hash)
            db.session.add(new_user)
            db.session.commit()
            success = True
    

    return render_template("index.html", errors=errors, success=success)

@app.route("/login", methods=["GET", "POST"])
def login():
    errors = []
    form = LoginForm()
    if form.validate_on_submit():
        user = User.query.filter_by(username=form.username.data).first()
        if user:
            if check_password_hash(user.password, form.password.data):
                # return redirect("/profile")
                return redirect(url_for("profile"))
        
        errors.append("Something went wrong!")

    return render_template("login.html", form=form, errors=errors)

@app.route("/profile")
def profile():
    return render_template("profile.html")

@app.route("/reset", methods=["GET", "POST"])
def reset():
    msg = ""
    form = ResetForm()
    if form.validate_on_submit():
        user = User.query.filter_by(username=form.username.data)
        if user:
            user.password = generate_password_hash(form.new_password.data)
            db.session.commit()
            msg = "Password reset successfully"
        else:
            msg = "Something went wrong!"

    return render_template("reset.html", form=form, msg=msg)

if __name__ == "__main__":
    app.run(debug=True, host="127.0.0.1", port=8000)