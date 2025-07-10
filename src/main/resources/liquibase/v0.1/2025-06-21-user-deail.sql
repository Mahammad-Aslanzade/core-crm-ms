create table user_detail
(
    id                            VARCHAR PRIMARY KEY,
    phone_number                  VARCHAR NOT NULL,
    address                       VARCHAR NOT NULL,
    current_salary                DECIMAL(10, 3),
    employment_start_date         TIMESTAMP,
    employment_end_date           TIMESTAMP,
    employment_termination_reason VARCHAR,
    created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by                    VARCHAR,
    updated_at                    TIMESTAMP,
    updated_by                    VARCHAR
);

create table "user"
(
    id              VARCHAR PRIMARY KEY,
    name            VARCHAR NOT NULL,
    surname         VARCHAR NOT NULL,
    email           VARCHAR NOT NULL UNIQUE,
    internal_number INTEGER UNIQUE,
    detail_id       VARCHAR,
    foreign key (detail_id) references user_detail (id),

    current_job_id  VARCHAR,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR
);