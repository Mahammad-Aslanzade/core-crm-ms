create table user_verification
(
    verification_code varchar not null primary key,
    user_id           varchar not null,
    created_at        timestamp default current_timestamp,
    foreign key (user_id) references "user" (id)
);