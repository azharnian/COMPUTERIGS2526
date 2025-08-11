from flask import Flask, jsonify, render_template
from database import get_db, close_db

app = Flask(__name__)

@app.route("/")
def index():
    return render_template("index.html")

@app.route("/about")
def about():
    return render_template("about.html")

@app.route("/contact")
def contact():
    return render_template("contact.html")

@app.route("/news")
def news():
    db = get_db()
    news = db.execute("SELECT * FROM NEWS").fetchall()

    return render_template("news.html", news=news)

@app.route("/temperature")
def temperature():
    return jsonify({"status" : True, "value" : 100})

if __name__ == "__main__":
    app.run(
        debug=True,
        host="127.0.0.1",
        port=8000
    )