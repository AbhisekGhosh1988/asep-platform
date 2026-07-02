# SAD-006 – Module Architecture

---

# Document Information

| Property | Value |
|----------|-------|
| Document ID | SAD-006 |
| Document Name | Module Architecture |
| Product | ASEP (AI Software Engineering Platform) |
| Version | 1.0 |
| Status | Approved |
| Owner | Architecture Team |
| Author | Abhisek Ghosh |
| Created | 2026-07-02 |
| Last Updated | 2026-07-02 |

---

# Executive Summary

This document defines the logical module architecture of ASEP.

The platform is implemented as a **Spring Modulith** with clearly defined business modules.

Each module represents a bounded context and owns its business logic, domain model, persistence, APIs, and events.

The architecture enforces high cohesion, low coupling, and independent evolution while remaining deployable as a single application.

---

# Module Organization

ASEP consists of four major groups of modules.

```
ASEP Platform

│

├── Foundation Modules

├── Platform Modules

├── Engineering Modules

└── AI Modules
```

Each group has a clearly defined responsibility.

---

# Foundation Modules

These modules provide reusable infrastructure and platform capabilities.

## platform-runtime

Responsibilities

- Application bootstrap
- Spring Boot configuration
- Module initialization

Depends On

None

---

## platform-shared-kernel

Responsibilities

- Base entities
- Value objects
- Domain events
- Common exceptions
- Common utilities
- Result model
- Audit model
- Version model

This module contains no business logic.

---

## platform-sdk

Responsibilities

- Public interfaces
- DTO contracts
- Extension contracts
- Plugin interfaces

---

# Platform Modules

## platform-identity

Responsibilities

- Authentication
- Authorization
- Users
- Roles
- Permissions
- Sessions

Publishes

- UserCreated
- UserUpdated
- RoleAssigned

---

## platform-organization

Responsibilities

- Organizations
- Workspaces
- Teams
- Memberships

Publishes

- OrganizationCreated
- WorkspaceCreated

Depends On

Identity

---

## platform-project

Responsibilities

- Projects
- Repositories
- Technology Stack
- Project Configuration

Publishes

- ProjectCreated
- RepositoryLinked

Depends On

Organization

---

## platform-notification

Responsibilities

- Notifications
- Email
- Slack
- Teams
- In-App Notifications

---

## platform-audit

Responsibilities

- Audit History
- Compliance Logs
- Activity Timeline

---

# Engineering Modules

## platform-requirement

Responsibilities

- Requirements
- User Stories
- Business Rules
- Acceptance Criteria

Publishes

- RequirementCreated
- RequirementApproved

Depends On

Project

---

## platform-workflow

Responsibilities

- Workflow Engine
- State Machine
- Approvals
- Assignments

Publishes

- WorkflowStarted
- WorkflowCompleted

Depends On

Requirement

---

## platform-architecture

Responsibilities

- Architecture Models
- Components
- APIs
- Database Models
- Diagrams

Publishes

- ArchitectureGenerated
- ArchitectureApproved

Depends On

Requirement

---

## platform-engineering-assets

Responsibilities

Manage all engineering assets.

Owns

- Asset Registry
- Version History
- Relationships
- Metadata

Publishes

- AssetCreated
- AssetUpdated

This module is central to ASEP.

---

## platform-knowledge-graph

Responsibilities

- Traceability
- Dependency Graph
- Semantic Relationships
- Impact Analysis

Depends On

Engineering Assets

---

# AI Modules

## platform-ai-orchestrator

Responsibilities

- Agent Coordination
- Prompt Routing
- Context Assembly
- AI Sessions

Publishes

- AIJobStarted
- AIJobCompleted

---

## platform-ai-generation

Responsibilities

- Backend Generation
- API Generation
- Database Generation
- Documentation Generation

Depends On

AI Orchestrator

---

## platform-ai-review

Responsibilities

- Code Review
- Architecture Review
- Security Review
- Best Practice Review

Depends On

AI Orchestrator

---

## platform-ai-learning

Responsibilities

- Prompt History
- Engineering Patterns
- Recommendation Learning

Future Module

---

# Integration Modules

## platform-github

Responsibilities

- Repository Import
- Webhooks
- Pull Requests
- Branches
- Synchronization

Publishes

- PullRequestCreated
- RepositoryImported

---

## platform-external

Responsibilities

- Jira
- Azure DevOps
- Slack
- Teams

Acts as an Anti-Corruption Layer.

---

# Module Dependency Rules

Modules communicate through:

- Public Services
- Published Interfaces
- Domain Events

Modules must never:

- Access another module's database tables.
- Use another module's JPA entities.
- Call internal services.
- Create circular dependencies.

---

# Recommended Package Structure

Each module follows the same internal structure.

```
module

├── api
│
├── application
│
├── domain
│
├── infrastructure
│
├── events
│
├── mapper
│
├── config
│
└── package-info.java
```

---

# Spring Modulith Verification

Every module must satisfy:

- No cyclic dependencies
- Explicit module boundaries
- Verified dependencies
- Published interfaces only

Architecture tests must validate these rules.

---

# Module Evolution Strategy

Phase 1

Modular Monolith

↓

Phase 2

Independent Modules

↓

Phase 3

Extractable Microservices

No business redesign should be required during extraction.

---

# Module Summary

The ASEP Module Architecture maps business capabilities directly to Spring Modulith modules.

Each module owns a single business responsibility and collaborates through published contracts, enabling independent evolution while maintaining a cohesive enterprise platform.

---

# Related Documents

- SAD-005 – Bounded Contexts
- SAD-007 – Shared Kernel
- SAD-008 – Event Architecture

---

# Change History

| Version | Date | Description |
|----------|------|-------------|
| 1.0 | 2026-07-02 | Initial Version |