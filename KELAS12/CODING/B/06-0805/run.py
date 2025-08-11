from flask import Flask, render_template
from database import get_db

from datetime import datetime

app = Flask(__name__)

@app.route("/")
def index():
    db = get_db()
    cursor = db.execute('SELECT * FROM users')
    users = cursor.fetchall()
    names = []

    for id, name in users:
        names.append(name)

    today = datetime.now()

    if (today.day == 1 and today.month == 1):
        new_year = True
    else:
        new_year = False

    return render_template("index.html", names=names, new_year=new_year)

if __name__ == "__main__":
    app.run(
        debug=True,
        host="127.0.0.1",
        port="8000"
    )