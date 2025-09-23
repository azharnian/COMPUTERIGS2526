from flask import Flask, render_template, request, g
import sqlite3
from datetime import datetime

app = Flask(__name__)

database = "./data.db"

def get_db():
    db = getattr(g, "_database", None)
    if db is None:
        db = g._database = sqlite3.connect(database)
    return db

def close_db():
    db = g.pop('db', None)
    if db is not None:
        db.close()

users = [
    {
        "first" : "Budi",
        "last" : "Santoso"
    },
    {
        "first" : "Cindy",
        "last" : "Siregar"
    }
]

@app.route("/", methods=["GET", "POST"]) 
def index():
    if request.method == "POST":
        first = request.form.get("first")
        last = request.form.get("last")

        user = {"first" : first, "last" : last}
        users.append(user)

    return render_template("index.html", users=users) 

@app.route("/isitnewyear")
def isitnewyear():
    today = datetime.now()

    new_year = "NO"
    if today.day == 1 and today.month == 1:
        new_year = "YES"
        
    return render_template("newyear.html", new_year=new_year)



if __name__ == "__main__":
    app.run(
        debug=True,
        host="127.0.0.1",
        port=8080
    )
