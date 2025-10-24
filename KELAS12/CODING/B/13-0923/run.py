from flask import Flask
from flask_migrate import Migrate

from config import Config
from app.services.database import db

from app.routes import main_bp

def create_app():
    app = Flask(__name__)
    app.config.from_object(Config)
    db.init_app(app)
    Migrate(app, db)

    app.register_blueprint(main_bp)

    return app

if __name__ == "__main__":
    app = create_app()
    with app.app_context():
        db.create_all()
    app.run(debug=True, host="127.0.0.1", port=8000)