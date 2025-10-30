from datetime import datetime
from flask_login import UserMixin

from app.services import db
from app.services import login_manager

@login_manager.user_loader
def load_user(user_id):
    return User(user_id)

class User(db.Model, UserMixin):
    __tablename__ = "users"
    id          = db.Column(db.Integer, primary_key=True)
    username    = db.Column(db.String(32), nullable=False, index=True)
    password    = db.Column(db.String(256), nullable=False)
    email       = db.Column(db.String(128), nullable=False, index=True)
    created_at  = db.Column(db.DateTime, default=datetime.utcnow, nullable=False)

    def __init__(self, id, username, password, email):
        self.id = id
        self.username = username
        self.password = password
        self.email = email
        self.created_at = datetime.utcnow

    def get_id(self):
        return str(self.id)


class Student(db.Model):
    __tablename__ = "students"
    id          = db.Column(db.Integer, primary_key=True)
    nisn        = db.Column(db.String(32), nullable=False, index=True)
    fullname    = db.Column(db.String(128), nullable=False, index=True)
    created_at  = db.Column(db.DateTime, default=datetime.utcnow, nullable=False)