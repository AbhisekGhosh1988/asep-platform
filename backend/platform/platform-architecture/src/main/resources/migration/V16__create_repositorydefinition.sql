CREATE TABLE repository_definitions
(
    id VARCHAR(36) PRIMARY KEY,

    aggregate_id VARCHAR(36) NOT NULL,

    name VARCHAR(255) NOT NULL,

    description TEXT,

    created_by VARCHAR(100),

    created_at TIMESTAMP NOT NULL,

    updated_by VARCHAR(100),

    updated_at TIMESTAMP,

    CONSTRAINT fk_repository_definition_aggregate
        FOREIGN KEY (aggregate_id)
            REFERENCES aggregates(id),

    CONSTRAINT uk_repository_definition
        UNIQUE (
                aggregate_id,
                name
            )
);

CREATE INDEX idx_repository_definition_aggregate
    ON repository_definitions(aggregate_id);