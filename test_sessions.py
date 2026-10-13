"""
Black box testing
CREATES a new session, GETS the session, DELETES, GETS again,
returns proper error codes 
"""
import requests

BASE = "http://localhost:8080"

def test_create_get_delete():
    body = {
        "minWaveHeight": 2.0,
        "maxWaveHeight": 3.0,
        "rating": 7,
        "location": "Test Beach",
        "timeOfDay": "Morning",
        "date": "2026-10-01",
    }

    created = requests.post(f"{BASE}/sessions", json=body)
    assert created.status_code in (200, 201), created.text
    new_id = created.json()["id"]

    try:
        fetched = requests.get(f"{BASE}/sessions/{new_id}")
        assert fetched.status_code == 200, fetched.text
        assert fetched.json()["location"] == "Test Beach"

        deleted = requests.delete(f"{BASE}/sessions/{new_id}")
        assert deleted.status_code in (200, 204), deleted.text

        missing = requests.get(f"{BASE}/sessions/{new_id}")
        assert missing.status_code == 404, missing.text
    finally:
        # Keep the test repeatable if an earlier assertion fails.
        requests.delete(f"{BASE}/sessions/{new_id}")