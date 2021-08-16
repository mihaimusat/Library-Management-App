CREATE TABLE book (
                      id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
                      author varchar(50) NOT NULL,
                      title varchar(255) NOT NULL,
                      publication_year INT,
                      status enum("available", "ordered") NOT NULL,
                      PRIMARY KEY (id)
);

CREATE TABLE reader (
                        id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
                        name varchar(50) NOT NULL,
                        registration_date DATETIME NOT NULL,
                        PRIMARY KEY (id)
);

CREATE TABLE reader_order (
                              id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
                              book_id BIGINT NOT NULL,
                              reader_id BIGINT NOT NULL,
                              rental_date DATETIME NOT NULL,
                              return_date DATETIME NOT NULL,
                              PRIMARY KEY (id),
                              FOREIGN KEY (book_id) REFERENCES book (id),
                              FOREIGN KEY (reader_id) REFERENCES reader (id)
);

CREATE TABLE order_entry (
                             order_id BIGINT NOT NULL,
                             reader_id BIGINT NOT NULL,
                             FOREIGN KEY (order_id) REFERENCES reader_order (id),
                             FOREIGN KEY (reader_id) REFERENCES reader (id)
);

-- adding books
INSERT INTO book (author, title, publication_year, status)
VALUES ("Ion Creanga", "Amintiri din copilarie", 1892, "available");

INSERT INTO book (author, title, publication_year, status)
VALUES ("Camil Petrescu", "Patul lui Procust", 1933, "available");

INSERT INTO book (author, title, publication_year, status)
VALUES ("Mihail Sadoveanu", "Baltagul", 1930, "ordered");

INSERT INTO book (author, title, publication_year, status)
VALUES ("Liviu Rebreanu", "Ion", 1920, "ordered");

-- adding readers
INSERT INTO reader (name, registration_date)
VALUES ("Mihai", sysdate());

INSERT INTO reader (name, registration_date)
VALUES ("Andrei", sysdate());

-- adding orders for readers
INSERT INTO reader_order (book_id, reader_id, rental_date, return_date)
VALUES (2, 1, sysdate(), '2021-08-12');

INSERT INTO reader_order (book_id, reader_id, rental_date, return_date)
VALUES (1, 2, sysdate(), '2021-08-12');

-- adding list of orders in a distinct table (one to many)
INSERT INTO order_entry (order_id, reader_id)
VALUES (1, 1);

INSERT INTO order_entry (order_id, reader_id)
VALUES (2, 2);
