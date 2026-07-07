CREATE TABLE attributes (

                            id VARCHAR(36) PRIMARY KEY,

                            entity_id VARCHAR(36) NOT NULL,

                            name VARCHAR(255) NOT NULL,

                            data_type VARCHAR(100) NOT NULL,

                            required BOOLEAN NOT NULL,

                            nullable BOOLEAN NOT NULL,

                            is_unique BOOLEAN NOT NULL,

                            is_collection BOOLEAN NOT NULL,

                            default_value VARCHAR(255),

                            length INTEGER,

                            precision INTEGER,

                            scale INTEGER,

                            description TEXT,

                            created_by VARCHAR(100),

                            created_at TIMESTAMP NOT NULL,

                            updated_by VARCHAR(100),

                            updated_at TIMESTAMP,

                            CONSTRAINT fk_attribute_entity
                                FOREIGN KEY (entity_id)
                                    REFERENCES entities(id)

);

CREATE INDEX idx_attribute_entity
    ON attributes(entity_id);