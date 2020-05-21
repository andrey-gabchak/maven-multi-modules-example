CREATE TABLE currency
(
    id               SERIAL      NOT NULL PRIMARY KEY,
    name             VARCHAR(50) NOT NULL,
    is_main_currency BOOLEAN     NOT NULL,
    exchange_rate    NUMERIC(4, 2)
);
