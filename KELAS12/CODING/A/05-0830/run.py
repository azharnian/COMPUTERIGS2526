import dotenv

from app import db, create_app

dotenv.load_dotenv()
app = create_app()

with app.app_context():
    db.create_all()

if __name__ == '__main__':
    app.run( host='0.0.0.0',
             port=443 )

