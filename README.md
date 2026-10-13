# Barrelwatch

Barrelwatch is a surf session journal. Log a session’s spot, date, time of day, wave heights, and rating, then browse, edit, or delete sessions.

## Built with

- Java and Spring Boot
- PostgreSQL
- Docker Compose
- Python, pytest, and Requests for API testing

## Run locally

1. Create a `.env` file with `POSTGRES_DB`, `POSTGRES_USER`, and `POSTGRES_PASSWORD`.
2. Start the database:

   ```bash
   docker compose up -d
   ```

3. Load the environment variables and start Spring Boot:

   ```bash
   set -a
   source .env
   set +a
   sh mvnw spring-boot:run
   ```

4. Open [http://localhost:8080](http://localhost:8080) to use the journal.

## API

- `GET /sessions` — list sessions
- `GET /sessions/{id}` — retrieve a session
- `POST /sessions` — create a session
- `PUT /sessions/{id}` — update a session
- `DELETE /sessions/{id}` — delete a session

## Run the API test

With the app and database running, install the Python dependencies if needed and run:

```bash
python3 -m pip install pytest requests
pytest -v
```
