from flask import Flask, jsonify

from routes.player import player_api

app = Flask(__name__)
app.config["DEBUG"] = True


@app.route("/")
def info():
    return "<h1>Gully Cricket</h5>" \
           "<p>Gully cricket tournament manager</p>"


@app.route("/health")
def health():
    return "Ok"


app.register_blueprint(player_api)


if __name__ == "__main__":
    app.run()

