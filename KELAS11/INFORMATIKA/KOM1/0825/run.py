from flask import Flask, render_template

app = Flask(__name__)

@app.route("/")
def index():
    return render_template("home.html")

@app.route("/login")
def login():
    return "This is login Page"

@app.route("/signup")
def signup():
    return "This is Sign up Page"

@app.route("/profile")
def profile():
    return "This is Profile Page"

app.run(debug=True, host="127.0.0.1", port=8000)