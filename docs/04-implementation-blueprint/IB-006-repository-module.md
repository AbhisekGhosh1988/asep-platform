# IB-006 – Repository Module

---

Module

platform-github

---

Responsibilities

- Repository Import
- Branch Management
- Synchronization
- Metadata Extraction
- Webhooks

---

Aggregate

GitRepository

---

Entities

GitRepository

Branch

Commit

PullRequest

Webhook

---

Repositories

GitRepositoryRepository

BranchRepository

---

Application Services

ImportRepositoryUseCase

SynchronizeRepositoryUseCase

ProcessWebhookUseCase

---

Controllers

RepositoryController

WebhookController

---

Events

RepositoryImported

RepositorySynchronized

WebhookReceived

---

Generation Contract

Generate

Repository Integration

REST APIs

Webhook Processing

Tests

Preserve

Custom Git Logic