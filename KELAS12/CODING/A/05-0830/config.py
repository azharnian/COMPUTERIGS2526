from dotenv import load_dotenv
import os

load_dotenv()

class Config:
    SQLALCHEMY_TRACK_MODIFICATIONS = os.getenv("SQLALCHEMY_TRACK_MODIFICATIONS", "False")

    # Redis session config
    SESSION_TYPE = 'redis'
    SESSION_REDIS = None  # Set later
    SESSION_PERMANENT = True
    SESSION_USE_SIGNER = True
    SESSION_KEY_PREFIX = 'session:'
    PERMANENT_SESSION_LIFETIME = 30 * 60  # 30 minutes

class DevelopmentConfig(Config):
    DEBUG = True
    ENV = 'development'
    SQLALCHEMY_DATABASE_URI = os.getenv("SQLALCHEMY_DATABASE_URI_DEV", "sqlite:///default.db")
    SECRET_KEY = os.getenv("SECRET_KEY", "secret123456")

app_config = DevelopmentConfig