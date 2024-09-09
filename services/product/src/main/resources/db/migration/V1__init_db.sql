CREATE TABLE IF NOT EXISTS category
(
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS product
(
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    available_quantity double precision NOT NULL,
    price numeric(38, 2) NOT NULL,
    category_id INTEGER constraint category_id_fk references category
);

CREATE sequence if not exists category_seq start with 1 increment by 1;
CREATE sequence if not exists product_seq start with 1 increment by 1;
