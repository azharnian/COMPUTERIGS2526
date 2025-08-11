from sqlalchemy.orm import Session
from app.domains.entities.user import User
import hashlib

def hash_password(password: str) -> str:
    return hashlib.sha256(password.encode()).hexdigest()

def add_user(db: Session, id: int = 1, full_name="Test User", email="test@example.com", password="secret"):
    hashed = hash_password(password)
    user = User(
        id=id,
        full_name=full_name,
        email=email,
        hashed_password=hashed,
        is_active=True,
        is_deleted=False,
    )
    db.add(user)
    db.commit()
    db.refresh(user)
    return user

def clean_table(db: Session):
    db.query(User).delete()
    db.commit()

def find_user_by_email(db: Session, email: str):
    return db.query(User).filter(User.email == email).first()
