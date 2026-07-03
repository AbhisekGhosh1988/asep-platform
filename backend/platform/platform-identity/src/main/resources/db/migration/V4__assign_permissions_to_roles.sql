-- ==========================================================
-- SUPER_ADMIN
-- Gets every permission in the platform
-- ==========================================================

INSERT INTO role_permissions (role_id, permission_id)
SELECT
    '11111111-1111-1111-1111-111111111111',
    id
FROM permissions
    ON CONFLICT DO NOTHING;



-- ==========================================================
-- ADMIN
-- Administrative permissions except SYSTEM_ADMIN
-- ==========================================================

INSERT INTO role_permissions(role_id, permission_id)
SELECT
    '22222222-2222-2222-2222-222222222222',
    id
FROM permissions
WHERE name <> 'SYSTEM_ADMIN'
    ON CONFLICT DO NOTHING;



-- ==========================================================
-- ARCHITECT
-- ==========================================================

INSERT INTO role_permissions(role_id,permission_id)
SELECT
    '33333333-3333-3333-3333-333333333333',
    id
FROM permissions
WHERE name IN
      (
       'PROJECT_READ',
       'PROJECT_UPDATE',

       'REQUIREMENT_READ',
       'REQUIREMENT_UPDATE',

       'AI_GENERATE',
       'AI_REVIEW',

       'COMPILER_EXECUTE',
       'CODE_GENERATE',
       'CODE_DOWNLOAD'
          )
    ON CONFLICT DO NOTHING;



-- ==========================================================
-- BUSINESS_ANALYST
-- ==========================================================

INSERT INTO role_permissions(role_id,permission_id)
SELECT
    '44444444-4444-4444-4444-444444444444',
    id
FROM permissions
WHERE name IN
      (
       'PROJECT_READ',

       'REQUIREMENT_CREATE',
       'REQUIREMENT_READ',
       'REQUIREMENT_UPDATE',

       'AI_GENERATE'
          )
    ON CONFLICT DO NOTHING;



-- ==========================================================
-- DEVELOPER
-- ==========================================================

INSERT INTO role_permissions(role_id,permission_id)
SELECT
    '55555555-5555-5555-5555-555555555555',
    id
FROM permissions
WHERE name IN
      (
       'PROJECT_READ',

       'REQUIREMENT_READ',

       'COMPILER_EXECUTE',
       'CODE_GENERATE',
       'CODE_DOWNLOAD'
          )
    ON CONFLICT DO NOTHING;



-- ==========================================================
-- TESTER
-- ==========================================================

INSERT INTO role_permissions(role_id,permission_id)
SELECT
    '66666666-6666-6666-6666-666666666666',
    id
FROM permissions
WHERE name IN
      (
       'PROJECT_READ',

       'REQUIREMENT_READ',

       'CODE_DOWNLOAD'
          )
    ON CONFLICT DO NOTHING;



-- ==========================================================
-- DEVOPS
-- ==========================================================

INSERT INTO role_permissions(role_id,permission_id)
SELECT
    '77777777-7777-7777-7777-777777777777',
    id
FROM permissions
WHERE name IN
      (
       'SYSTEM_MONITOR',

       'PROJECT_READ',

       'CODE_DOWNLOAD'
          )
    ON CONFLICT DO NOTHING;



-- ==========================================================
-- PRODUCT_OWNER
-- ==========================================================

INSERT INTO role_permissions(role_id,permission_id)
SELECT
    '88888888-8888-8888-8888-888888888888',
    id
FROM permissions
WHERE name IN
      (
       'PROJECT_CREATE',
       'PROJECT_READ',
       'PROJECT_UPDATE',

       'REQUIREMENT_CREATE',
       'REQUIREMENT_READ',
       'REQUIREMENT_UPDATE'
          )
    ON CONFLICT DO NOTHING;



-- ==========================================================
-- SCRUM_MASTER
-- ==========================================================

INSERT INTO role_permissions(role_id,permission_id)
SELECT
    '99999999-9999-9999-9999-999999999999',
    id
FROM permissions
WHERE name IN
      (
       'PROJECT_READ',

       'REQUIREMENT_READ',

       'AI_GENERATE'
          )
    ON CONFLICT DO NOTHING;



-- ==========================================================
-- VIEWER
-- ==========================================================

INSERT INTO role_permissions(role_id,permission_id)
SELECT
    'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    id
FROM permissions
WHERE name IN
      (
       'PROJECT_READ',
       'REQUIREMENT_READ'
          )
    ON CONFLICT DO NOTHING;