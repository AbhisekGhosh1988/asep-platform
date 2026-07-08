CREATE TABLE policy_definitions
(

    id VARCHAR(36) PRIMARY KEY,

    aggregate_id VARCHAR(36) NOT NULL,

    name VARCHAR(255) NOT NULL,

    description TEXT,

    created_by VARCHAR(100),

    created_at TIMESTAMP NOT NULL,

    updated_by VARCHAR(100),

    updated_at TIMESTAMP,

    CONSTRAINT fk_policy_definition_aggregate
        FOREIGN KEY (aggregate_id)
            REFERENCES aggregates(id),

    CONSTRAINT uk_policy_definition
        UNIQUE (
                aggregate_id,
                name
            )

);

CREATE INDEX idx_policy_definition_aggregate
    ON policy_definitions(aggregate_id);