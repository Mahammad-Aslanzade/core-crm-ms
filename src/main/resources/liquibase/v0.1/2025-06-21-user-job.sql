create table user_job
(
    user_id VARCHAR NOT NULL,
    job_id  VARCHAR NOT NULL,
    foreign key (user_id) references "user" (id),
    foreign key (job_id) references job (id)
);