CREATE TABLE job
(
    id            VARCHAR PRIMARY KEY,
    title         VARCHAR UNIQUE,
    department_id varchar,
    foreign key (department_id) references department (id),
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by    VARCHAR,
    updated_at    TIMESTAMP,
    updated_by    VARCHAR
);
