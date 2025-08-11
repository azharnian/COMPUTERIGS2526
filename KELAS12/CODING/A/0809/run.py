from flask import Flask, render_template, request
from flask_socketio import SocketIO, emit, join_room
import uuid

app = Flask(__name__)

app.config['SECRET_KEY'] = 'secret!'

socket = SocketIO(app)

votes = {"option1": 0, "option2": 0}
rooms = {}

@app.route("/")
def index():
    return render_template("index.html", votes=votes)

@app.route("/circle-room/<room_id>")
def circle_room(room_id):
    if room_id not in rooms:
        rooms[room_id] = {}
    return render_template("game.html", room_id=room_id)

@app.route("/create-circle-room")
def create_circle_room():
    room_id = str(uuid.uuid4())[:6]
    rooms[room_id] = {}
    return f"Room created! Join here: /circle-room/{room_id}"

# VOTE FEATURE
@socket.on("vote")
def handle_vote(data):
    option = data["option"]
    if option in votes:
        votes[option] += 1
        print(votes)
        emit("vote_count", votes, broadcast=True)

# GAME FEATURE
@socket.on("join_room_game")
def join_room_game(data):
    room_id = data["room_id"]
    color = data["color"]
    join_room(room_id)
    rooms[room_id][request.sid] = {"x": 100, "y": 100, "color": color}
    emit("update_players", rooms[room_id], room=room_id)

@socket.on("move_circle")
def move_circle(data):
    room_id = data["room_id"]
    if request.sid in rooms.get(room_id, {}):
        rooms[room_id][request.sid]["x"] = data["x"]
        rooms[room_id][request.sid]["y"] = data["y"]
        emit("update_players", rooms[room_id], room=room_id)

@socket.on("disconnect")
def on_disconnect():
    for room_id in list(rooms.keys()):
        if request.sid in rooms[room_id]:
            del rooms[room_id][request.sid]
            emit("update_players", rooms[room_id], room=room_id)

if __name__ == "__main__":
    socket.run(app, 
               debug=True,
               host="127.0.0.1",
               port=8080)
