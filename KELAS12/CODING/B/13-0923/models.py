from datetime import datetime

from extensions import db

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