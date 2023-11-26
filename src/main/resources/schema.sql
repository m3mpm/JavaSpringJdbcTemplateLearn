CREATE TABLE IF NOT EXISTS purchase(
    id serial primary key,
    product varchar(50) not null,
    price double precision not null
);

-- INSERT INTO purchase(product, price) VALUES ('banans',67);

-- DELETE FROM purchase;
-- ALTER SEQUENCE purchase_id_seq RESTART WITH 1;