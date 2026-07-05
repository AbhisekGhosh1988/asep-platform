CREATE TABLE projects
(
    id              VARCHAR(50) PRIMARY KEY,

    name            VARCHAR(255) NOT NULL UNIQUE,

    description     TEXT,

    owner_id        VARCHAR(50) NOT NULL,

    status          VARCHAR(30) NOT NULL,

    ai_provider     VARCHAR(50) NOT NULL,

    backend         VARCHAR(100),

    frontend        VARCHAR(100),

    database_name   VARCHAR(100),

    messaging       VARCHAR(100),

    build_tool      VARCHAR(100),

    cloud           VARCHAR(100),

    container       VARCHAR(100),

    created_at      TIMESTAMP,

    updated_at      TIMESTAMP
);