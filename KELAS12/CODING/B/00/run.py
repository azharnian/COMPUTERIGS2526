from flask import Flask, jsonify, render_template

app = Flask("__main__")

@app.route("/")
def index():
    return render_template("index.html")

@app.route("/temperature")
def temperature():
    return jsonify({ "status" : True, "value" : 100})

if __name__ == "__main__":
    app.run(
        debug=True, 
        host="127.0.0.1",
        port=8000
        )