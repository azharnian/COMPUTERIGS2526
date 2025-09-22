from flask import Flask

app = Flask(__name__)

@app.route("/")
def index():
    return "Anas Azhar - XI IPA KOM 2"

if __name__ == "__main__":
    app.run(
        debug=True,
        host="127.0.0.1",
        port=8080
    )