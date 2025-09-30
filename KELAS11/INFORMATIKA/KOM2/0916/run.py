from flask import Flask, render_template, request, g
import sqlite3

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

    if request.method == "POST":
        first = request.form.get("first")
        last = request.form.get("last")
        hobbies = request.form.get("hobbies")

        user = {
            "first" : first,
            "last" : last,
            "hobbies" : ",".join(hobbies.split(","))
        }
        db.execute("""
            INSERT INTO users (first, last, hobbies)
            VALUES (?, ?, ?)
        """, (user["first"], user["last"], user["hobbies"],));
        db.commit();
    
    users = db.execute("SELECT * FROM users;")

    return render_template("index.html", users=users)

if __name__ == "__main__":
    app.run(
        debug=True,
        host="127.0.0.1",
        port=8080
    )