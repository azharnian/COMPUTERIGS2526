from flask import Blueprint, render_template
from werkzeug.security import check_password_hash

from app.forms.loginForm import LoginForm
from app.models.users import User

auth_bp = Blueprint("auth", __name__, url_prefix="/auth")

@auth_bp.route("/login", methods=["GET", "POST"])
def login():
    form = LoginForm()

    if form.validate_on_submit():
        user = User.query.filter_by(username = form.username.data).first()
        if (user and check_password_hash(form.password.data, user.password)):
            return True

    return render_template("auth/login.html", form=form)