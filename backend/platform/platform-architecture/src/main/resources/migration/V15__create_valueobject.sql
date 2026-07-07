CREATE TABLE value_objects
(

    id VARCHAR(36) PRIMARY KEY,

    aggregate_id VARCHAR(36) NOT NULL,

    name VARCHAR(255) NOT NULL,

    description TEXT,
    immutable BOOLEAN NOT NULL,
    created_by VARCHAR(100),

    created_at TIMESTAMP NOT NULL,

    updated_by VARCHAR(100),

    updated_at TIMESTAMP,

    CONSTRAINT fk_value_object_aggregate
        FOREIGN KEY (aggregate_id)
            REFERENCES aggregates(id),

    CONSTRAINT uk_value_object
        UNIQUE (
                aggregate_id,
                name
            )

);

CREATE INDEX idx_value_object_aggregate
    ON value_objects(aggregate_id);