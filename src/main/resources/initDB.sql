
CREATE DATABASE sberbank;
\c sberbank;

CREATE TABLE LOGIN_TABLE (
    id SERIAL,
    login VARCHAR(20)
);

CREATE TABLE ANSWERS_TABLE (
    id SERIAL,
    answer VARCHAR(50)
);

CREATE TABLE QUESTIONS_TABLE (
    id SERIAL,
    question VARCHAR(100),
    answer_id INT,
    user_id INT
);