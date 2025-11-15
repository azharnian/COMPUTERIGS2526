from flask import request, render_template, redirect, url_for, Blueprint
from werkzeug.security import generate_password_hash,\
                                check_password_hash

from flask_login import login_required, login_user, logout_user, current_user

from app.forms.login_form import LoginForm
from app.forms.reset_form import ResetForm

from app.models.users import User

from app.services import db

main_bp = Blueprint("main", __name__)

@main_bp.route("/")
def index():
    return redirect(url_for("main.login"))

@main_bp.route("/login", methods=["GET", "POST"])
def login():
    form = LoginForm()
    errors = []

    if form.validate_on_submit():
        user = User.query.filter_by(username=form.username.data).first()

        if user and check_password_hash(user.password, form.password.data):
            login_user(user)
            return redirect(url_for("main.profile"))
        else:
            errors.append("Username atau password salah")

    return render_template("login.html", form=form, errors=errors)

@main_bp.route("/profile")
@login_required
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

@main_bp.route("/logout")
@login_required
def logout():
    logout_user()
    return redirect(url_for("main.login"))
