import sqlite3
from flask import Flask, render_template, g, request
from datetime import datetime

app = Flask(__name__)

DATABASE = "./data.db"

def get_db():
    db = getattr(g, '_database', None)
    if db is None:
        db = g._database = sqlite3.connect(DATABASE)
    return db


def close_db():
    db = g.pop('db', None)
    if db is not None:
        db.close()


@app.route("/", methods=["GET", "POST"])
def index():
    db = get_db()
    msg = ""

    if request.method == "POST":
        first = request.form.get("first")
        last = request.form.get("last")
        email = request.form.get("email")

        db.execute("""
            INSERT INTO User (first, last, email) VALUES 
                   (?, ?, ?)
        """, (first, last, email,))
        db.commit()
        msg = "Add user success."

    users = db.execute(""" SELECT * FROM User """).fetchall()
    return render_template("index.html", users=users, msg=msg)

@app.route("/isitnewyear")
def isitnewyear():
    # today = datetime.now()
    # if today.month == 1 and today.day == 1:
    #     newyear = True
    # else:
    #     newyear = False
    return render_template("newyear.html")

if __name__ == "__main__":
    app.run(
        debug = True,
        host = "0.0.0.0",
        port = 8080
    )