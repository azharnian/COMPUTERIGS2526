from datetime import datetime
from sqlalchemy import func
from backend.db import db

class User(db.Model):
    __tablename__ = 'users'
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(80), unique=True, nullable=False)
    created_at = db.Column(db.DateTime, server_default=func.now())

    def to_dict(self):
        return {'id': self.id, 'username': self.username}

class Room(db.Model):
    __tablename__ = 'rooms'
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(120), unique=True, nullable=False)
    history_json = db.Column(db.Text, nullable=False, default='[]')
    created_at = db.Column(db.DateTime, server_default=func.now())

    def to_dict(self, with_history=False):
        base = {'id': self.id, 'name': self.name}
        if with_history:
            base['history_json'] = self.history_json
        return base
