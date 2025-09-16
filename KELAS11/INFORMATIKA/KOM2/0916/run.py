from flask import Flask

app = Flask(__name__)

@app.route("/")
def index():
    return "Web server is ready! by Anas Azhar 11 Komputer 2 - 16 Sept 2025"

if __name__ == "__main__":
    app.run(
        debug=True,
        host="127.0.0.1",
        port=8080
    )