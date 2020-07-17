
CREATE TABLE IF NOT EXISTS Users (
    name VARCHAR(15) NOT NULL,
    surname VARCHAR(15) NOT NULL,
    login VARCHAR(15) NOT NULL,
    password VARCHAR(10) NOT NULL,
    email VARCHAR(20) NOT NULL,
    info TEXT,
    createdAt DATE NOT NULL
);