CREATE TABLE users
(
    id              VARCHAR(36) PRIMARY KEY,
    username        VARCHAR(100) NOT NULL UNIQUE,
    email           VARCHAR(255) NOT NULL UNIQUE,
    password        VARCHAR(255) NOT NULL,
    first_name      VARCHAR(100),
    last_name       VARCHAR(100),
    status          VARCHAR(30) NOT NULL,
    created_at      TIMESTAMP NOT NULL,
    updated_at      TIMESTAMP NOT NULL
);

CREATE TABLE roles
(
    id          VARCHAR(36) PRIMARY KEY,
    role_type   VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE permissions
(
    id              VARCHAR(36) PRIMARY KEY,
    name            VARCHAR(150) NOT NULL UNIQUE,
    description     VARCHAR(500)
);

CREATE TABLE refresh_tokens
(
    id              VARCHAR(36) PRIMARY KEY,
    token           VARCHAR(500) NOT NULL UNIQUE,
    user_id         VARCHAR(36) NOT NULL,
    expiry_date     TIMESTAMP NOT NULL,
    revoked         BOOLEAN NOT NULL,
    created_at      TIMESTAMP NOT NULL,

    CONSTRAINT fk_refresh_user
        FOREIGN KEY(user_id)
            REFERENCES users(id)
            ON DELETE CASCADE
);

CREATE TABLE user_roles
(
    user_id     VARCHAR(36) NOT NULL,
    role_id     VARCHAR(36) NOT NULL,

    PRIMARY KEY(user_id, role_id),

    CONSTRAINT fk_user_roles_user
        FOREIGN KEY(user_id)
            REFERENCES users(id)
            ON DELETE CASCADE,

    CONSTRAINT fk_user_roles_role
        FOREIGN KEY(role_id)
            REFERENCES roles(id)
            ON DELETE CASCADE
);

CREATE TABLE role_permissions
(
    role_id         VARCHAR(36) NOT NULL,
    permission_id   VARCHAR(36) NOT NULL,

    PRIMARY KEY(role_id, permission_id),

    CONSTRAINT fk_role_permission_role
        FOREIGN KEY(role_id)
            REFERENCES roles(id)
            ON DELETE CASCADE,

    CONSTRAINT fk_role_permission_permission
        FOREIGN KEY(permission_id)
            REFERENCES permissions(id)
            ON DELETE CASCADE
);

CREATE INDEX idx_user_username
    ON users(username);

CREATE INDEX idx_user_email
    ON users(email);

CREATE INDEX idx_refresh_token
    ON refresh_tokens(token);