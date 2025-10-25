from flask import request, render_template, redirect, url_for, Blueprint
from werkzeug.security import generate_password_hash,\
                                check_password_hash

from flask_login import login_required

from app.services.database import db
from app.models import User
from app.forms import LoginForm, ResetForm

main_bp = Blueprint("main", __name__)

@main_bp.route("/", methods=["GET", "POST"])
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

@main_bp.route("/login", methods=["GET", "POST"])
def login():
    errors = []
    form = LoginForm()
    if form.validate_on_submit():
        user = User.query.filter_by(username=form.username.data).first()
        if user:
            if check_password_hash(user.password, form.password.data):
                # return redirect("/profile")
                return redirect(url_for("main.profile"))
        
        errors.append("Something went wrong!")

    return render_template("login.html", form=form, errors=errors)

@login_required
@main_bp.route("/profile")
def profile():
    return render_template("profile.html")

@main_bp.route("/reset", methods=["GET", "POST"])
def reset():
    msg = ""
    form = ResetForm()
    if form.validate_on_submit():
        user = User.query.filter_by(username=form.username.data).first()
        print(user)
        if user:
            user.password = generate_password_hash(form.new_password.data)
            db.session.commit()
            msg = "Password reset successfully"
        else:
            msg = "Something went wrong!"

    return render_template("reset.html", form=form, msg=msg)
