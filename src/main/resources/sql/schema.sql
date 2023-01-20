CREATE TABLE IF NOT EXISTS url_entry
(
    id                  BIGINT Generated Always as Identity PRIMARY KEY,
    hash                char(22) UNIQUE NOT NULL,
    url                 TEXT UNIQUE NOT NULL,
    created_date        TIMESTAMP,
    last_modified_date  TIMESTAMP,
    hits                BIGINT DEFAULT 1
);