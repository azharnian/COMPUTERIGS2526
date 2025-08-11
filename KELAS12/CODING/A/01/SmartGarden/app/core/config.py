import os
from pathlib import Path
from dotenv import load_dotenv

env_file = '.test.env' if os.getenv("NODE_ENV") == "test" else '.env'
load_dotenv(dotenv_path=Path('.') / env_file)

class Settings:
    NODE_ENV: str = os.getenv("NODE_ENV", "development")
    DATABASE_URL: str = os.getenv("DATABASE_URL", "dev.db")

settings = Settings()
