CREATE TABLE requirements (

                              id VARCHAR(255) PRIMARY KEY,

                              project_id VARCHAR(255) NOT NULL,

                              title VARCHAR(500) NOT NULL,

                              description TEXT,

                              type VARCHAR(255) NOT NULL,

                              status VARCHAR(255) NOT NULL,

                              priority VARCHAR(255) NOT NULL,

                              complexity VARCHAR(255) NOT NULL,

                              source VARCHAR(255) NOT NULL,

                              risk VARCHAR(255) NOT NULL,

                              version INTEGER NOT NULL,

                              parent_requirement_id VARCHAR(255),

                              created_by VARCHAR(255),

                              approved_by VARCHAR(255),

                              created_at TIMESTAMP NOT NULL,

                              updated_at TIMESTAMP NOT NULL,
                              updated_by VARCHAR(255)

);


CREATE TABLE requirement_tags (

                                  requirement_id VARCHAR(36) NOT NULL,

                                  tag VARCHAR(100) NOT NULL,

                                  PRIMARY KEY(requirement_id, tag)

);

CREATE TABLE requirement_comments (

                                      id VARCHAR(36) PRIMARY KEY,

                                      requirement_id VARCHAR(36) NOT NULL,

                                      comment TEXT,

                                      created_by VARCHAR(36),

                                      created_at TIMESTAMP

);

CREATE TABLE requirement_attachments (

                                         id VARCHAR(36) PRIMARY KEY,

                                         requirement_id VARCHAR(36) NOT NULL,
                                         original_file_name VARCHAR(255),
                                         file_size           BIGINT,

                                         file_name VARCHAR(255),

                                         file_type VARCHAR(100),

                                         storage_path VARCHAR(1000),

                                         uploaded_by VARCHAR(36),

                                         uploaded_at TIMESTAMP,

                                         content_type VARCHAR(255)

);

CREATE TABLE requirement_versions (

                                      id VARCHAR(36) PRIMARY KEY,

                                      requirement_id VARCHAR(36),

                                      version INTEGER,

                                      snapshot TEXT,

                                      created_by VARCHAR(36),

                                      created_at TIMESTAMP

);

CREATE TABLE requirement_traces (

                                    id VARCHAR(36) PRIMARY KEY,

                                    requirement_id VARCHAR(36),

                                    target_type VARCHAR(100),

                                    target_id VARCHAR(36),

                                    created_at TIMESTAMP

);

CREATE TABLE requirement_ai_analysis (

                                         id VARCHAR(36) PRIMARY KEY,

                                         requirement_id VARCHAR(36),

                                         completeness_score DOUBLE PRECISION,

                                         ambiguity_score DOUBLE PRECISION,

                                         quality_score DOUBLE PRECISION,

                                         analysis TEXT,

                                         created_at TIMESTAMP

);

CREATE TABLE trace_links (

                             id VARCHAR(36) PRIMARY KEY,

                             source_type VARCHAR(50) NOT NULL,

                             source_id VARCHAR(36) NOT NULL,

                             target_type VARCHAR(50) NOT NULL,

                             target_id VARCHAR(36) NOT NULL,

                             relation_type VARCHAR(50) NOT NULL,

                             created_by VARCHAR(36),

                             created_at TIMESTAMP

);

CREATE INDEX idx_trace_source
    ON trace_links(source_type, source_id);

CREATE INDEX idx_trace_target
    ON trace_links(target_type, target_id);

CREATE INDEX idx_trace_relation
    ON trace_links(relation_type);