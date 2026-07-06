CREATE TABLE bounded_contexts (

                                  id VARCHAR(36) PRIMARY KEY,

                                  architecture_id VARCHAR(36) NOT NULL,

                                  name VARCHAR(255) NOT NULL,

                                  description TEXT,

                                  responsibility TEXT,

                                  created_by VARCHAR(100),

                                  created_at TIMESTAMP NOT NULL,

                                  updated_by VARCHAR(100),

                                  updated_at TIMESTAMP,

                                  CONSTRAINT fk_bc_architecture
                                      FOREIGN KEY (architecture_id)
                                          REFERENCES architectures(id)

);

CREATE INDEX idx_bc_architecture
    ON bounded_contexts(architecture_id);

CREATE TABLE microservices (

                               id VARCHAR(36) PRIMARY KEY,

                               bounded_context_id VARCHAR(36) NOT NULL,

                               name VARCHAR(255) NOT NULL,

                               description TEXT,

                               style VARCHAR(50),

                               created_by VARCHAR(100),

                               created_at TIMESTAMP NOT NULL,

                               updated_by VARCHAR(100),

                               updated_at TIMESTAMP,

                               CONSTRAINT fk_ms_bc
                                   FOREIGN KEY (bounded_context_id)
                                       REFERENCES bounded_contexts(id)

);

CREATE INDEX idx_ms_bc
    ON microservices(bounded_context_id);