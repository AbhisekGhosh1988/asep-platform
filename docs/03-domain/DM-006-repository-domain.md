# DM-006 – Repository Domain

---

# Executive Summary

The Repository Domain manages source code repositories and their relationship with engineering projects.

Repositories remain the source of truth for source code, while ASEP remains the source of truth for engineering knowledge.

---

# Aggregate Root

Repository

---

# Entities

- Repository
- Branch
- Tag
- CommitReference
- RepositoryWebhook

---

# Value Objects

- RepositoryId
- RepositoryUrl
- BranchName
- CommitHash

---

# Domain Services

RepositorySynchronizationService

RepositoryImportService

BranchManagementService

---

# Domain Events

RepositoryImported

BranchCreated

BranchDeleted

RepositorySynchronized

WebhookReceived

---

# Business Rules

- Repository belongs to one Project.
- Repository may contain multiple branches.
- Main branch is protected.
- Repository synchronization is incremental.
- Repository metadata is versioned.

---

# Repository

RepositoryRepository

---

# Public APIs

- Import Repository
- Refresh Repository
- List Branches
- Configure Webhooks
- Synchronize Metadata

---

# Module

platform-github