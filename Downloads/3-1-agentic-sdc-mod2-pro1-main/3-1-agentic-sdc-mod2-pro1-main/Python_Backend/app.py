from flask import Flask, request, jsonify
from chatbot import generate_response

app = Flask(__name__)


@app.route("/")
def home():
    return "AI Chatbot Backend Running"


@app.route("/chat", methods=["POST"])
def chat():

    data = request.get_json()

    message = data.get("message", "")

    reply = generate_response(message)

    return jsonify(
        {
            "reply": reply
        }
    )


if __name__ == "__main__":
    app.run(
        host="0.0.0.0",
        port=5000,
        debug=True
    )