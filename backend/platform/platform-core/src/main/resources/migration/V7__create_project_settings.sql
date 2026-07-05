CREATE TABLE project_settings
(
    id                    VARCHAR(50) PRIMARY KEY,

    project_id            VARCHAR(50) NOT NULL UNIQUE,

    repository_url        VARCHAR(500),

    default_branch        VARCHAR(100),

    backend_framework     VARCHAR(50),

    frontend_framework    VARCHAR(50),

    database              VARCHAR(50),

    build_tool            VARCHAR(50),

    java_version          INTEGER,

    container_platform    VARCHAR(50),

    cloud_provider        VARCHAR(50),

    ai_provider           VARCHAR(50),

    llm_model             VARCHAR(50),

    architecture_style    VARCHAR(50),

    created_at            TIMESTAMP,

    updated_at            TIMESTAMP
);