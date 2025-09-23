from flask import Flask, render_template, request

app = Flask(__name__)

users = [
    {
        "first" : "Budi",
        "last" : "Santoso",
        "hobbies" : ["Run", "Watch Movies"]
    },
    {
        "first" : "Cindy",
        "last" : "Siregar",
        "hobbies" : []
    }
]

@app.route("/", methods=["GET", "POST"])
def index():
    if request.method == "POST":
        first = request.form.get("first")
        last = request.form.get("last")
        hobbies = request.form.get("hobbies")

        user = {
            "first" : first,
            "last" : last,
            "hobbies" : list(hobbies.split(","))
        }
        users.append(user)

    return render_template("index.html", users=users)

if __name__ == "__main__":
    app.run(
        debug=True,
        host="127.0.0.1",
        port=8080
    )