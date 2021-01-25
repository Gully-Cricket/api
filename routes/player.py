import os

from flask import jsonify, abort, Blueprint
import psycopg2
from psycopg2.extras import RealDictCursor

player_api = Blueprint('player_api', __name__)


# A route to return all players
@player_api.route('/players', methods=['GET'])
def player_all():
    conn = None
    players = []
    error = False
    try:
        conn = psycopg2.connect(
            host=os.environ['host'],
            database=os.environ['database'],
            user=os.environ['user'],
            password=os.environ['password'])
        cur = conn.cursor(cursor_factory=RealDictCursor)
        cur.execute("SELECT * FROM player")
        players = cur.fetchall()

        cur.close()
    except (Exception, psycopg2.DatabaseError) as e:
        error = True
        print(e)
    finally:
        if conn is not None:
            conn.close()

    if error:
        abort(500)

    return jsonify(players)


# A route to return a player by id
@player_api.route('/players/<player_id>', methods=['GET'])
def player_one(player_id):
    conn = None
    player = None
    error = False

    try:
        conn = psycopg2.connect(
            host=os.environ['host'],
            database=os.environ['database'],
            user=os.environ['user'],
            password=os.environ['password'])
        cur = conn.cursor(cursor_factory=RealDictCursor)
        cur.execute("SELECT * FROM player WHERE id = (%s)", (player_id,))
        player = cur.fetchone()

        cur.close()
    except (Exception, psycopg2.DatabaseError) as e:
        error = True
        print(e)
    finally:
        if conn is not None:
            conn.close()

    if error:
        abort(500)

    if player is None:
        abort(404)

    return jsonify(player)
