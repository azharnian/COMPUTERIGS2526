from flask import Flask, g, render_template, request, jsonify
import sqlite3

app = Flask(__name__)

# === DB helpers ===
DATABASE = "./data.db"

def get_db():
    db = getattr(g, "db", None)
    if db is None:
        db = g.db = sqlite3.connect(DATABASE)
        db.row_factory = sqlite3.Row  # optional: akses kolom sebagai dict
    return db

@app.teardown_appcontext
def close_db(exception):
    db = getattr(g, "db", None)
    if db is not None:
        db.close()

# ====== ROUTES ======

@app.route("/news")
def news():
    db = get_db()
    news = db.execute("SELECT * FROM news").fetchall()
    return render_template("news.html", news=news)

@app.route("/contact", methods=["GET", "POST"])
def contact():
    """
    Catatan:
    - Pastikan form di contact.html pakai name: name, email, msg
      (bukan username/phone/mail), agar sinkron dengan tabel contacts.
    - Tabel contacts diasumsikan: id INTEGER PK, name TEXT, email TEXT, msg TEXT
    """
    error = None
    if request.method == "POST":
        user = {
            "name": request.form.get("name"),
            "email": request.form.get("email"),
            "msg": request.form.get("msg"),
        }

        if user["name"] and user["email"] and user["msg"]:
            db = get_db()
            db.execute(
                "INSERT INTO contacts (name, email, msg) VALUES (?, ?, ?)",
                (user["name"], user["email"], user["msg"]),
            )
            db.commit()
            success = True
        else:
            success = False
            error = "Required: name, email, and message."

        return render_template("contact.html", success=success, user=user, error=error)

    return render_template("contact.html")

@app.route("/admin", methods=["GET", "POST", "DELETE"])
def admin():
    db = get_db()

    if request.method == "DELETE":
        payload = request.get_json(silent=True) or {}
        contact_id = payload.get("id")

        # Validasi sederhana
        try:
            contact_id = int(contact_id)
        except (TypeError, ValueError):
            return jsonify({"delete": "fail", "msg": "invalid id"}), 400

        data = db.execute(
            "SELECT * FROM contacts WHERE id = ?", (contact_id,)
        ).fetchone()

        if data:
            db.execute("DELETE FROM contacts WHERE id = ?", (contact_id,))
            db.commit()
            # 200 OK + JSON berisi id agar front-end bisa hapus baris
            return jsonify({"delete": "success", "id": contact_id}), 200
        else:
            return jsonify({"delete": "fail", "msg": "data doesn't exist"}), 404

    if request.method == "POST":
        data = request.get_json(silent=True) or {}
        # Tambahkan logic simpan/update sesuai kebutuhan
        return jsonify({"status": "success", "data": data}), 200

    contacts = db.execute("SELECT * FROM contacts").fetchall()
    return render_template("admin.html", contacts=contacts)

if __name__ == "__main__":
    app.run(debug=True, host="127.0.0.1", port=8080)
