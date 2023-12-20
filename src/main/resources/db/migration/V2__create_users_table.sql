CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100)               NOT NULL,
    password VARCHAR(100)               NOT NULL,
    enable   BOOLEAN     DEFAULT TRUE,
    role     VARCHAR(50) DEFAULT 'USER' NOT NULL
);