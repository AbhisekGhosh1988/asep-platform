CREATE TABLE api_contracts
(

    id VARCHAR(36) PRIMARY KEY,

    aggregate_id VARCHAR(36) NOT NULL,

    name VARCHAR(255) NOT NULL,

    method VARCHAR(20) NOT NULL,

    path VARCHAR(500) NOT NULL,

    description TEXT,

    created_by VARCHAR(100),

    created_at TIMESTAMP NOT NULL,

    updated_by VARCHAR(100),

    updated_at TIMESTAMP,

    CONSTRAINT fk_api_contract_aggregate
        FOREIGN KEY (aggregate_id)
            REFERENCES aggregates(id),

    CONSTRAINT uk_api_contract
        UNIQUE (
                aggregate_id,
                name
            )

);

CREATE INDEX idx_api_contract_aggregate
    ON api_contracts(aggregate_id);