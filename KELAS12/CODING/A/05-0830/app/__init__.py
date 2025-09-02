from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate
from flask_wtf.csrf import CSRFProtect
from flask_login import LoginManager

from config import app_config

db = SQLAlchemy()
csrf = CSRFProtect()
login_manager = LoginManager()

from app.services.cache.session import init_redis_session
from config import app_config

def create_app():
    app = Flask(__name__)
    app.config.from_object(app_config)

    db.init_app(app)
    init_redis_session(app)

    csrf.init_app(app)
    login_manager.init_app(app)

    migrate = Migrate(app, db, render_as_batch=True)

    return app