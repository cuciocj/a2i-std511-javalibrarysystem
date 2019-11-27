
-- Drop table

-- DROP TABLE public.admins;

CREATE TABLE public.admins (
	id serial NOT NULL,
	name varchar NOT NULL,
	username varchar NOT NULL,
	"password" varchar NOT NULL,
	CONSTRAINT admins_pkey PRIMARY KEY (id),
	CONSTRAINT admins_un UNIQUE (username)
);

-- Drop table

-- DROP TABLE public.books;

CREATE TABLE public.books (
	id serial NOT NULL,
	title varchar NOT NULL,
	author varchar NOT NULL,
	isbn varchar NOT NULL,
	genre varchar NOT NULL,
	publisher varchar NOT NULL,
	publication_year int4 NOT NULL,
	quantity int4 NOT NULL,
	CONSTRAINT books_isbn_key UNIQUE (isbn),
	CONSTRAINT books_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.students;

CREATE TABLE public.students (
	id serial NOT NULL,
	school_id varchar NOT NULL,
	name varchar NOT NULL,
	CONSTRAINT students_pkey PRIMARY KEY (id),
	CONSTRAINT students_school_id_key UNIQUE (school_id)
);

-- Drop table

-- DROP TABLE public.transactions;

CREATE TABLE public.transactions (
	id serial NOT NULL,
	student_id int4 NOT NULL,
	book_id int4 NOT NULL,
	quantity int4 NOT NULL,
	status status NOT NULL,
	date_borrowed varchar NOT NULL,
	due_date varchar NOT NULL,
	date_returned varchar NOT NULL,
	admin_id int4 NOT NULL,
	CONSTRAINT transactions_pkey PRIMARY KEY (id),
	CONSTRAINT transactions_admin_id_fkey FOREIGN KEY (admin_id) REFERENCES admins(id),
	CONSTRAINT transactions_book_id_fkey FOREIGN KEY (book_id) REFERENCES books(id),
	CONSTRAINT transactions_student_id_fkey FOREIGN KEY (student_id) REFERENCES students(id)
);
