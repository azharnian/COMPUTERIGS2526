from flask import Blueprint, request, render_template
from werkzeug.security import generate_password_hash

from app.models.users import User
from app.services import db

users_bp = Blueprint("users", __name__, url_prefix="/users")

@users_bp.route("/register", methods=["GET", "POST"])
def register():
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