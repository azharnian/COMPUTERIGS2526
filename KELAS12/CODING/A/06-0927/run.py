from flask import Flask, request, render_template
from problem import PROBLEM
from judge import judge

app = Flask(__name__)

PY_STARTER = 'print("Hello, World!")\n'
CPP_STARTER = (
    '#include <bits/stdc++.h>\n'
    'using namespace std;\n'
    'int main(){ cout << "Hello, World!" << endl; }\n'
)

@app.route("/", methods=["GET", "POST"])
def index():
    lang = request.form.get("lang", "python")
    code = request.form.get("code", PY_STARTER if lang == "python" else CPP_STARTER)
    result = None
    if request.method == "POST":
        result = judge(lang, code)
    return render_template(
        "index.html",
        problem=PROBLEM,
        expected=PROBLEM["expected_stdout"],
        lang=lang,
        code=code,
        result=result,
    )

if __name__ == "__main__":
    app.run(
        debug=True,
        host="0.0.0.0",
        port=8080    
    )
