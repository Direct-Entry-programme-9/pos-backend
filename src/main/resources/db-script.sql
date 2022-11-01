CREATE TABLE customer(
                         id VARCHAR(36) PRIMARY KEY ,
                         name VARCHAR(100) NOT NULL ,
                         address VARCHAR(300) NOT NULL
);

INSERT INTO customer(id, name, address)
VALUES (UUID(), 'Kasun', 'Galle'),
       (UUID(), 'Nuwan', 'Mathara'),
       (UUID(), 'Ruwan', 'Homagama'),
       (UUID(), 'Supun', 'Maharagama'),
       (UUID(), 'Prem', 'Colombo');