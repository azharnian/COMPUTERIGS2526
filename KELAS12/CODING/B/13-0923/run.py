from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

import os
from dotenv import load_dotenv
from datetime import datetime

load_dotenv()

app = Flask(__name__)
app.config["SQLALCHEMY_DATABASE_URI"] = os.getenv("DB_URI")
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False

db = SQLAlchemy(app)
migrate = Migrate(app, db)

# Tables or Models

class User(db.Model):
    __tablename__ = "users"
    id          = db.Column(db.Integer, primary_key=True)
    username    = db.Column(db.String(32), nullable=False, index=True)
    email       = db.Column(db.String(128), nullable=False, index=True)
    created_at  = db.Column(db.DateTime, default=datetime.utcnow, nullable=False)

class Student(db.Model):
    __tablename__ = "students"
    id          = db.Column(db.Integer, primary_key=True)
    nisn        = db.Column(db.String(32), nullable=False, index=True)
    fullname    = db.Column(db.String(128), nullable=False, index=True)
    created_at  = db.Column(db.DateTime, default=datetime.utcnow, nullable=False)

@app.route("/")
def index():
    return "OK"
