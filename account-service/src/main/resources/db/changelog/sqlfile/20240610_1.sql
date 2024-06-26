CREATE TABLE IF NOT EXISTS "user".users (
	id serial4 NOT NULL,
	account varchar NOT NULL,
    password varchar NOT NULL,
	email varchar NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);
