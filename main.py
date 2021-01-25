import os

import flask
from flask import request, jsonify, abort
import psycopg2
from psycopg2.extras import RealDictCursor

app = flask.Flask(__name__)
app.config["DEBUG"] = True

# Create some test data for our catalog in the form of a list of dictionaries.
books = []


@app.route('/', methods=['GET'])
def home():
    return '''<h1>Gully Cricket</h1>
<p>Gully cricket tournament manager</p>'''


# A route to return all of the available entries in our catalog.
@app.route('/players', methods=['GET'])
def api_all():
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
        cur.execute("SELECT* FROM player")
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


@app.route('/api/v1/resources/books', methods=['GET'])
def api_id():
    # Check if an ID was provided as part of the URL.
    # If ID is provided, assign it to a variable.
    # If no ID is provided, display an error in the browser.
    if 'id' in request.args:
        book_id = int(request.args['id'])
    else:
        return "Error: No id field provided. Please specify an id."

    # Create an empty list for our results
    results = []

    # Loop through the data and match results that fit the requested ID.
    # IDs are unique, but other fields might return many results
    for book in books:
        if book['id'] == book_id:
            results.append(book)

    # Use the jsonify function from Flask to convert our list of
    # Python dictionaries to the JSON format.
    return jsonify(results)


app.run()
