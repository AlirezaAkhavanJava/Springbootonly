ALTER TABLE account_user
    ADD COLUMN public_id uuid;


UPDATE account_user
SET public_id = gen_random_uuid()
WHERE account_user.public_id IS NULL;

ALTER TABLE account_user
    ALTER COLUMN public_id SET NOT NULL;

ALTER TABLE account_user
    ADD CONSTRAINT uk_account_user_public_id UNIQUE (public_id);