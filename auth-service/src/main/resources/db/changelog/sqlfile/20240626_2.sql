CREATE TABLE IF NOT EXISTS account.account (
	id serial4 NOT NULL,
	account varchar NOT NULL,
    password varchar NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT account_id PRIMARY KEY (id),
    CONSTRAINT account_unique UNIQUE (account)
);
