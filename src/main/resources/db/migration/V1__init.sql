CREATE TABLE branch (
    id NUMERIC NOT NULL PRIMARY KEY,
    name VARCHAR NOT NULL,
    api_key VARCHAR
);

CREATE TABLE sub_branch (
    id NUMERIC NOT NULL PRIMARY KEY,
    name VARCHAR NOT NULL,
    branch_id NUMERIC NOT NULL,
    CONSTRAINT fk__branch_id FOREIGN KEY (branch_id) REFERENCES branch (id)
);
