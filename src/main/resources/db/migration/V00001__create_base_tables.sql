


CREATE TABLE IF NOT EXISTS band (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    description VARCHAR(250),
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    adress_id              int,
    deleted                boolean NOT NULL DEFAULT false
    );
