CREATE TABLE department
(
    id              VARCHAR PRIMARY KEY,
    name            VARCHAR UNIQUE NOT NULL,
    short_name      VARCHAR UNIQUE NOT NULL,
    address         VARCHAR,
    hot_call_number VARCHAR UNIQUE NOT NULL,
    created_at      TIMESTAMP               DEFAULT CURRENT_TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR
);
