CREATE TABLE IF NOT EXISTS public.users (
	id serial4 NOT NULL,
	"name" varchar NULL,
	email varchar NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);