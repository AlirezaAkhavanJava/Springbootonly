-- 1) ON DELETE CASCADE: a constraint can't be altered, so drop and re-add it
ALTER TABLE account_orders
    DROP CONSTRAINT fk_order_account_owner;
ALTER TABLE account_orders
    ADD CONSTRAINT fk_order_account_owner
        FOREIGN KEY (account_owner_id) REFERENCES account_user (id)
            ON DELETE CASCADE;

-- PostgreSQL doesn't index foreign keys automatically; cascades and joins need this
CREATE INDEX idx_account_orders_account_owner_id ON account_orders (account_owner_id);

-- 2) One role column: the entity maps to user_role, so drop the other one
--    (its check constraint disappears with it)
ALTER TABLE account_user
    DROP COLUMN role;

-- 3) Identity -> sequence, to match @SequenceGenerator
ALTER TABLE account_user ALTER COLUMN id DROP IDENTITY;

CREATE SEQUENCE IF NOT EXISTS account_owner_seq START WITH 100 INCREMENT BY 1;

-- if Hibernate created it earlier, force the increment to match allocationSize = 1
ALTER SEQUENCE account_owner_seq INCREMENT BY 1;

SELECT setval('account_owner_seq',
              GREATEST((SELECT COALESCE(MAX(id), 0) FROM account_user) + 1, 100),
              false);

