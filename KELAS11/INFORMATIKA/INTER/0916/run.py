from flask import Flask, render_template
import sqlite3

app = Flask(__name__)

database = "./data.db"

def get_db():
    pass

def close_db():
    pass

@app.route("/") #request end point via browser, via api, etc
def index():
    return render_template("index.html") #response yang dibuat oleh programmer



if __name__ == "__main__":
    app.run(
        debug=True,
        host="127.0.0.1",
        port=8080
    )
