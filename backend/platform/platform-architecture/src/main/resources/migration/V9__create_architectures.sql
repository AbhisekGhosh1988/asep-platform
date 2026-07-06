CREATE TABLE architectures (

                               id VARCHAR(36) PRIMARY KEY,

                               project_id VARCHAR(36) NOT NULL,

                               name VARCHAR(255) NOT NULL,

                               description TEXT,

                               style VARCHAR(50) NOT NULL,

                               status VARCHAR(50) NOT NULL,

                               version INTEGER NOT NULL,

                               created_by VARCHAR(100),

                               created_at TIMESTAMP NOT NULL,

                               updated_by VARCHAR(100),

                               updated_at TIMESTAMP

);

ALTER TABLE architectures
    ADD CONSTRAINT uk_architecture_project_name
        UNIQUE (project_id, name);

CREATE INDEX idx_architecture_project
    ON architectures(project_id);

CREATE INDEX idx_architecture_status
    ON architectures(status);