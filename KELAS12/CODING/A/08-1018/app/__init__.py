from flask import Flask

import os
from dotenv import load_dotenv

from app.extensions import db, migrate
from app.configs import DevConf, ProdConf
from app.routes.main_bp import main_bp

load_dotenv()

isDev = os.getenv("FLASK_DEBUG")

def create_app():
    # App Factory
    app = Flask(__name__)

    if isDev:
        app.config.from_object(DevConf)
    else:
        app.config.from_object(ProdConf)

    db.init_app(app)
    migrate.init_app(app, db)

    # Register Bp
    app.register_blueprint(main_bp)
    return app