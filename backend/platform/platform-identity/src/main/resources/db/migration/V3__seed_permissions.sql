-- =====================================================
-- SYSTEM
-- =====================================================

INSERT INTO permissions (id,name,description)
SELECT '00000000-0000-0000-0000-000000000001',
       'SYSTEM_ADMIN',
       'Complete platform administration'
    WHERE NOT EXISTS
(SELECT 1 FROM permissions WHERE name='SYSTEM_ADMIN');

INSERT INTO permissions (id,name,description)
SELECT '00000000-0000-0000-0000-000000000002',
       'SYSTEM_CONFIGURATION',
       'Manage platform configuration'
    WHERE NOT EXISTS
(SELECT 1 FROM permissions WHERE name='SYSTEM_CONFIGURATION');

INSERT INTO permissions (id,name,description)
SELECT '00000000-0000-0000-0000-000000000003',
       'SYSTEM_MONITOR',
       'View monitoring information'
    WHERE NOT EXISTS
(SELECT 1 FROM permissions WHERE name='SYSTEM_MONITOR');



-- =====================================================
-- USER MANAGEMENT
-- =====================================================

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000010',
     'USER_CREATE',
     'Create users')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000011',
     'USER_READ',
     'View users')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000012',
     'USER_UPDATE',
     'Update users')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000013',
     'USER_DELETE',
     'Delete users')
    ON CONFLICT DO NOTHING;



-- =====================================================
-- ROLE MANAGEMENT
-- =====================================================

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000020',
     'ROLE_CREATE',
     'Create roles')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000021',
     'ROLE_READ',
     'Read roles')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000022',
     'ROLE_UPDATE',
     'Update roles')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000023',
     'ROLE_DELETE',
     'Delete roles')
    ON CONFLICT DO NOTHING;



-- =====================================================
-- PROJECT
-- =====================================================

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000030',
     'PROJECT_CREATE',
     'Create projects')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000031',
     'PROJECT_READ',
     'Read projects')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000032',
     'PROJECT_UPDATE',
     'Update projects')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000033',
     'PROJECT_DELETE',
     'Delete projects')
    ON CONFLICT DO NOTHING;



-- =====================================================
-- REQUIREMENTS
-- =====================================================

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000040',
     'REQUIREMENT_CREATE',
     'Create requirements')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000041',
     'REQUIREMENT_READ',
     'Read requirements')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000042',
     'REQUIREMENT_UPDATE',
     'Update requirements')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000043',
     'REQUIREMENT_DELETE',
     'Delete requirements')
    ON CONFLICT DO NOTHING;



-- =====================================================
-- AI
-- =====================================================

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000050',
     'AI_GENERATE',
     'Generate artifacts using AI')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000051',
     'AI_REVIEW',
     'AI review access')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000052',
     'AI_APPROVE',
     'Approve AI generated content')
    ON CONFLICT DO NOTHING;



-- =====================================================
-- COMPILER
-- =====================================================

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000060',
     'COMPILER_EXECUTE',
     'Execute compiler')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000061',
     'CODE_GENERATE',
     'Generate source code')
    ON CONFLICT DO NOTHING;

INSERT INTO permissions VALUES
    ('00000000-0000-0000-0000-000000000062',
     'CODE_DOWNLOAD',
     'Download generated code')
    ON CONFLICT DO NOTHING;