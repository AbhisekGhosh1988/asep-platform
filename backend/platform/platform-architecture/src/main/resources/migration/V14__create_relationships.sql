CREATE TABLE relationships
(

    id VARCHAR(36) PRIMARY KEY,

    source_entity_id VARCHAR(36) NOT NULL,

    target_entity_id VARCHAR(36) NOT NULL,

    relationship_type VARCHAR(50) NOT NULL,

    field_name VARCHAR(255) NOT NULL,

    mapped_by VARCHAR(255),

    cascade_type VARCHAR(50) NOT NULL,

    fetch_type VARCHAR(50) NOT NULL,

    optional BOOLEAN NOT NULL,

    orphan_removal BOOLEAN NOT NULL,

    description TEXT,

    created_by VARCHAR(100),

    created_at TIMESTAMP NOT NULL,

    updated_by VARCHAR(100),

    updated_at TIMESTAMP,

    CONSTRAINT fk_relationship_source
        FOREIGN KEY (source_entity_id)
            REFERENCES entities(id),

    CONSTRAINT fk_relationship_target
        FOREIGN KEY (target_entity_id)
            REFERENCES entities(id)

);

CREATE INDEX idx_relationship_source
    ON relationships(source_entity_id);

CREATE INDEX idx_relationship_target
    ON relationships(target_entity_id);

ALTER TABLE relationships
    ADD CONSTRAINT uk_relationship
        UNIQUE (
                source_entity_id,
                target_entity_id,
                field_name
            );