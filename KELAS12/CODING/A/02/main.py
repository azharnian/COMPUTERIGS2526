from flask import Flask, jsonify
from random import randint
from datetime import datetime

app = Flask(__name__)

@app.route("/")
def index():
    return "<h1>Hello, world!</h1>"

@app.route("/temperature")
def temperature():
    temperature = randint(20, 35)
    return jsonify({
        "temperature": temperature,
        "unit": "C",
        "timestamp": datetime.utcnow().isoformat()
    }), 200

if __name__ == "__main__":
    app.run(
        debug=True,
        host="127.0.0.1",
        port=8080
    )