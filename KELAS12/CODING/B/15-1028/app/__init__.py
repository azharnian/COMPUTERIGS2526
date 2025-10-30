from flask import Flask

from app.config import Config
from app.services import db, login_manager, migrate
from app.routes.main_bp import main_bp

def create_app():
    app = Flask(__name__)
    app.config.from_object(Config)

    db.init_app(app)
    migrate.init_app(app, db)
    login_manager.init_app(app)

    login_manager.login_view = "main.login"

    app.register_blueprint(main_bp)
    return app