CREATE TABLE requirements (

                              id VARCHAR(36) PRIMARY KEY,

                              project_id VARCHAR(36) NOT NULL,

                              title VARCHAR(500) NOT NULL,

                              description TEXT,

                              type VARCHAR(50) NOT NULL,

                              status VARCHAR(50) NOT NULL,

                              priority VARCHAR(30) NOT NULL,

                              complexity VARCHAR(30) NOT NULL,

                              source VARCHAR(30) NOT NULL,

                              risk VARCHAR(30) NOT NULL,

                              version INTEGER NOT NULL,

                              parent_requirement_id VARCHAR(36),

                              created_by VARCHAR(36),

                              approved_by VARCHAR(36),

                              created_at TIMESTAMP NOT NULL,

                              updated_at TIMESTAMP NOT NULL

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

                                         file_name VARCHAR(255),

                                         file_type VARCHAR(100),

                                         file_path VARCHAR(1000),

                                         uploaded_by VARCHAR(36),

                                         uploaded_at TIMESTAMP

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