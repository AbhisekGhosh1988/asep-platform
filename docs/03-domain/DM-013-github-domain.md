# DM-013 – GitHub Domain

---

# Document Information

| Property | Value |
|----------|-------|
| Document ID | DM-013 |
| Product | ASEP |
| Version | 1.0 |
| Status | Approved |

---

# Executive Summary

The GitHub Domain integrates ASEP with GitHub repositories, pull requests, webhooks, commits, issues, and branches.

GitHub remains the source of truth for source code while ASEP remains the source of truth for engineering knowledge.

---

# Responsibilities

- Repository Import
- Branch Synchronization
- Pull Request Management
- Commit Tracking
- Webhook Processing
- Repository Metadata

---

# Aggregate Root

GitRepository

---

# Child Entities

Branch

PullRequest

PullRequestReview

Commit

WebhookEvent

RepositorySettings

---

# Value Objects

RepositoryId

RepositoryUrl

BranchName

CommitHash

PullRequestNumber

---

# Domain Services

RepositoryImportService

PullRequestService

WebhookProcessingService

CommitSynchronizationService

---

# Domain Events

RepositoryImported

RepositoryUpdated

PullRequestOpened

PullRequestMerged

PullRequestClosed

CommitDetected

WebhookProcessed

---

# Business Rules

- Repository belongs to exactly one Project.
- Repository URL is immutable.
- Webhooks must be validated.
- PR reviews are traceable.
- Commits synchronize incrementally.

---

# Public APIs

Import Repository

Sync Repository

Process Webhook

Get Pull Request

List Branches

---

# Repository

GitRepositoryRepository

---

# Module

platform-github