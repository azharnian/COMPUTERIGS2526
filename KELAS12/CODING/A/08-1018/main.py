import os
from dotenv import load_dotenv

from flask import Flask, render_template
from werkzeug.security import generate_password_hash, check_password_hash

from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, BooleanField, SubmitField
from wtforms.validators import DataRequired, Length, EqualTo

app = Flask(__name__)
app.config["SECRET_KEY"] = os.getenv("SECRET_KEY")
app.config["SQLALCHEMY_DATABASE_URI"] = os.getenv("DB_URI")
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False

load_dotenv()

db = SQLAlchemy(app)
migrate = Migrate(app, db)

class User(db.Model):
    __tablename__ = "users"
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(10), unique=True, nullable=False, index=True)
    fullname = db.Column(db.String(32), nullable=False)
    password = db.Column(db.String(256), nullable=False)

@app.route("/")
def index():
    return render_template("index.html")

class SignupForm(FlaskForm):
    username = StringField("Username", validators=[
        DataRequired(),
        Length(min=5, max=10)
    ])
    fullname = StringField("Fullname", validators=[
        DataRequired(),
        Length(min=5, max=32)
    ])
    password = PasswordField("Password", validators=[
        DataRequired(),
        EqualTo("confirm", message="Password must macth."),
        Length(min=8)
    ])
    confirm = PasswordField("Confirm", validators=[
        DataRequired(),
        Length(min=8)
    ])
    agreement = BooleanField("I agree", validators=[
        DataRequired()
    ])
    submit = SubmitField("Sign up")


@app.route("/signup", methods=["GET", "POST"])
def signup():
    form = SignupForm()
    msg = ""
    if form.validate_on_submit():
        user = User.query.filter_by(username=form.username.data).first()

        if user:
            msg = "User already exists"
        else:
            user = User( username=form.username.data,
                        fullname=form.fullname.data,
                        password=generate_password_hash(form.password.data)
                    )
            db.session.add(user)
            db.session.commit()
            msg = "User created."

    return render_template("signup.html", form=form, msg=msg)

if __name__ == "__main__":
    app.run(debug=True, host="127.0.0.1", port=5000)
