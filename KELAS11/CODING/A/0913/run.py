from flask import Flask, request, jsonify, render_template

app = Flask(__name__)

data = {
    "movies" : [
        "Harry Potter",
        "Titanic"
    ]
}

@app.route("/movie", methods=["GET", "POST", "DELETE", "PATCH"])
def movie():
    file = request.args.get("file")
    if file == "json":
        if request.method == "POST":
            data["movies"].append(request.json.get("movie"))

        if request.method == "DELETE":
            data["movies"].remove(request.json.get("movie"))

        if request.method == "PATCH":
            old = request.json.get("old")
            if old in data["movies"]:
                list_index = data["movies"].index(old)
                data["movies"][list_index] = request.json.get("new")

                return jsonify({"action" : "success"}), 200
            return jsonify({"status" : "Not found"}), 404
                

        return jsonify(data), 200 #json
    
    if request.method == "POST":
        data["movies"].append(request.form.get("movie"))
    
    return render_template("movie.html", data=data) #html

if __name__ == "__main__":
    app.run(
        debug=True,
        host="127.0.0.1",
        port=8080
    )