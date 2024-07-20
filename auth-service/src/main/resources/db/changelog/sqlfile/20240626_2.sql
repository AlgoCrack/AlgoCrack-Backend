CREATE TABLE IF NOT EXISTS account.account (
	id numeric NOT NULL,
    name varchar NOT NULL,
    given_name varchar NOT NULL,
    family_name varchar NOT NULL,
    picture varchar NOT NULL,
    email varchar NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT account_id PRIMARY KEY (id)
);
