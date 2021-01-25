CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE player (
    id uuid DEFAULT uuid_generate_v4 () PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL
);