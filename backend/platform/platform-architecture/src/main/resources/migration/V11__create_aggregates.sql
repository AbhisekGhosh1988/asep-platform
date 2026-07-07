CREATE TABLE aggregates (

                            id VARCHAR(36) PRIMARY KEY,

                            microservice_id VARCHAR(36) NOT NULL,

                            name VARCHAR(255) NOT NULL,

                            description TEXT,

                            created_by VARCHAR(100),

                            created_at TIMESTAMP NOT NULL,

                            updated_by VARCHAR(100),

                            updated_at TIMESTAMP,

                            CONSTRAINT fk_aggregate_microservice
                                FOREIGN KEY (microservice_id)
                                    REFERENCES microservices(id)

);

CREATE INDEX idx_aggregate_microservice
    ON aggregates(microservice_id);