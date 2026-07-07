CREATE TABLE entities (

                          id VARCHAR(36) PRIMARY KEY,

                          aggregate_id VARCHAR(36) NOT NULL,

                          name VARCHAR(255) NOT NULL,

                          description TEXT,

                          root_entity BOOLEAN NOT NULL,

                          created_by VARCHAR(100),

                          created_at TIMESTAMP NOT NULL,

                          updated_by VARCHAR(100),

                          updated_at TIMESTAMP,

                          CONSTRAINT fk_entity_aggregate
                              FOREIGN KEY (aggregate_id)
                                  REFERENCES aggregates(id)

);

CREATE INDEX idx_entity_aggregate
    ON entities(aggregate_id);