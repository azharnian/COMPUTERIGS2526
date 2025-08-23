from flask import Flask, g, render_template, request
import sqlite3

app = Flask(__name__)

# Connection Database SQLITE
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

@app.route("/news")
def news():
    db = get_db()
    news = db.execute("SELECT * FROM news").fetchall()
    
    return render_template("news.html", news=news)

@app.route("/contact", methods=["GET", "POST"])
def contact():
    if (request.method == "POST"):
        user = {
            "username" : request.form.get("username"),
            "phone" : request.form.get("phone"),
            "mail" : request.form.get("mail")
        }
        return render_template("contact.html", flag=request.method, user=user)

    return render_template("contact.html")

if __name__ == "__main__":
    app.run(
        debug=True,
        host="127.0.0.1",
        port=8080
    )
