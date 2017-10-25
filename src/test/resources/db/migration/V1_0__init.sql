CREATE TABLE book (
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
    NAME VARCHAR(100) NOT NULL,
    SHORT_DESCRIPTION VARCHAR(500)
);

INSERT INTO book (NAME, SHORT_DESCRIPTION) VALUES ('Catcher in the Rye', 'A book about Holden.')
INSERT INTO book (NAME, SHORT_DESCRIPTION) VALUES ('The Firm', 'A book about Lawyers.');

select * from book;