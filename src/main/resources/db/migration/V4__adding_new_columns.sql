ALTER TABLE account_orders
    ADD COLUMN price        numeric(12, 2) NOT NULL DEFAULT 0,
    ADD COLUMN payment_code varchar(64),
    ADD COLUMN order_name   VARCHAR(255)   NOT NULL DEFAULT '',
    ADD COLUMN purchased_at timestamptz    NOT NULL DEFAULT now();

UPDATE account_orders
SET payment_code = 'LEGACY-' || id::text
WHERE payment_code IS NULL;

ALTER TABLE account_orders
    ALTER COLUMN price DROP DEFAULT,
    ALTER COLUMN payment_code SET NOT NULL,
    ADD CONSTRAINT uk_account_orders_payment_code UNIQUE (payment_code),
    ADD CONSTRAINT ck_account_orders_price_non_negative CHECK (price >= 0);