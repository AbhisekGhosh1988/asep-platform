CREATE TABLE project_members
(
    id          VARCHAR(50) PRIMARY KEY,

    project_id  VARCHAR(50) NOT NULL,

    user_id     VARCHAR(50) NOT NULL,

    role        VARCHAR(50) NOT NULL,

    joined_at   TIMESTAMP,

    CONSTRAINT uk_project_user
        UNIQUE(project_id, user_id)
);