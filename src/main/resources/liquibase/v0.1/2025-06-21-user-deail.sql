create table user
(
    id              VARCHAR PRIMARY KEY,
    name            VARCHAR NOT NULL,
    surname         VARCHAR NOT NULL,
    email           VARCHAR NOT NULL UNIQUE,
    internal_number INTEGER UNIQUE,
    detail_id       VARCHAR,

    current_job_id  VARCHAR,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR
)