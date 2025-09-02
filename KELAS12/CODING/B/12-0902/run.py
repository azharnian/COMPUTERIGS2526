from flask import Flask, g, render_template, request, jsonify
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
    error = None
    if (request.method == "POST"):
        user = {
            "username" : request.form.get("username"),
            "phone" : request.form.get("phone"),
            "mail" : request.form.get("mail")
        }

        if (user["username"] and user["phone"] and user["mail"]):
            db = get_db()
            db.execute('''
                    INSERT INTO users (username, phone, mail) 
                    VALUES (?, ?, ?)
                    ''', 
                    (user["username"], user["phone"], user["mail"]))
            db.commit()
            success = True
        else:
            success = False
            error = "Required username, phone, and main."
        
        return render_template("contact.html" , success=success, user=user, error=error)

    return render_template("contact.html")

@app.route("/admin", methods=["GET", "POST"])
def admin():
    if request.method == "POST":
        data = request.get_json()
        return jsonify({"status" : "success", "data" : f"{data}"}), 200

    db = get_db()
    contacts = db.execute("SELECT * FROM contacts").fetchall()

    return render_template("admin.html", contacts=contacts)

if __name__ == "__main__":
    app.run(
        debug=True,
        host="127.0.0.1",
        port=8080
    )
