from flask_session import Session
from app.services.cache.client import redis_client

def init_redis_session(app):
    app.config['SESSION_REDIS'] = redis_client
    Session(app)