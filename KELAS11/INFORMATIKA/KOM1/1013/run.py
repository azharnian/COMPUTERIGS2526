from flask import Flask, request, render_template_string

app = Flask(__name__)

template = """
<html>
<head>
    <title>Args Request</title>
</head>
<body>
    <form method=get>
        <input name="search" placeholder="serach!"/>
        <button>search</button>
    </form>

    {% if search %}
    <div>
        <h1>Result</h1>
        <p>{{ search }}</p>
    </div>
    {% endif %}
</body>
</html>
"""

@app.route("/")
def index():
    search = request.args.get("search")
    return render_template_string(template, search=search)

app.run(debug=True, port=3000)