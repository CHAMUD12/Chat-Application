DROP DATABASE IF EXISTS chat_application;

CREATE DATABASE IF NOT EXISTS chat_application;

USE chat_application;

DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user(
    email VARCHAR(35) PRIMARY KEY,
    name VARCHAR(155) NOT NULL,
    password VARCHAR(30) NOT NULL
    );