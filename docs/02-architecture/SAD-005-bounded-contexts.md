# SAD-005 – Bounded Contexts

---

# Document Information

| Property | Value |
|----------|-------|
| Document ID | SAD-005 |
| Document Name | Bounded Contexts |
| Product | ASEP (AI Software Engineering Platform) |
| Version | 1.0 |
| Status | Approved |
| Owner | Architecture Team |
| Author | Abhisek Ghosh |
| Created | 2026-07-02 |
| Last Updated | 2026-07-02 |

---

# Executive Summary

ASEP adopts Domain-Driven Design (DDD) as its primary architectural style.

The platform is divided into independent bounded contexts, each responsible for a specific business capability.

Every bounded context owns its:

- Domain Model
- Business Rules
- Persistence
- REST APIs
- Events
- Workflows

No bounded context may directly access another context's internal implementation.

Communication occurs only through published interfaces or domain events.

---

# Why Bounded Contexts?

Software becomes difficult to evolve when business responsibilities overlap.

Bounded contexts provide:

- Clear ownership
- Independent evolution
- High cohesion
- Low coupling
- Better scalability
- Easier testing
- Future microservice readiness

---

# ASEP Context Map

```
                           +--------------------+
                           | Identity           |
                           +---------+----------+
                                     |
         +---------------------------+---------------------------+
         |                           |                           |
+--------v---------+       +---------v----------+      +--------v---------+
| Organization     |       | Project            |      | Notification     |
+--------+---------+       +---------+----------+      +------------------+
         |                           |
         |                           |
+--------v---------+       +---------v----------+
| Requirement      |------>| Workflow           |
+--------+---------+       +---------+----------+
         |                           |
         |                           |
+--------v---------+       +---------v----------+
| Architecture     |------>| Engineering Asset |
+--------+---------+       +---------+----------+
         |                           |
         |                           |
+--------v---------+       +---------v----------+
| AI Orchestrator  |------>| GitHub Integration |
+------------------+       +--------------------+
```

---

# Foundation Contexts

These contexts provide platform capabilities.

## Identity

Responsibilities

- Authentication
- Authorization
- Users
- Roles
- Permissions
- Sessions

Owns

- User
- Role
- Permission
- Authentication Policy

---

## Organization

Responsibilities

- Organizations
- Workspaces
- Teams
- Memberships

Owns

- Organization
- Workspace
- Team

---

## Project

Responsibilities

- Projects
- Technology Stack
- Repository Configuration
- Project Settings

Owns

- Project
- Repository
- Environment

---

## Notification

Responsibilities

- Notifications
- Email
- Slack
- Teams

Owns

- Notification
- Channel
- Template

---

## Audit

Responsibilities

- Audit Events
- Activity History
- Compliance

Owns

- Audit Entry

---

# Engineering Contexts

## Requirement

Responsibilities

- Requirements
- User Stories
- Business Rules
- Acceptance Criteria

Owns

- Requirement
- Business Rule
- User Story

Publishes

- RequirementCreated
- RequirementApproved
- RequirementUpdated

---

## Workflow

Responsibilities

- State Machines
- Approval Flows
- Assignments

Owns

- Workflow
- Workflow Step
- Approval

---

## Architecture

Responsibilities

- Solution Architecture
- Components
- APIs
- Database Models
- Sequence Diagrams

Owns

- Architecture
- Component
- API
- Database Model

Publishes

- ArchitectureApproved

---

## Engineering Asset

Responsibilities

Manage every engineering artifact.

Owns

- Engineering Asset
- Asset Version
- Asset Relationship

This is the core context of ASEP.

Every engineering artifact becomes an Engineering Asset.

---

## Knowledge Graph

Responsibilities

- Relationships
- Traceability
- Dependency Graph
- Semantic Search

Owns

- Graph Node
- Graph Edge

---

# AI Contexts

## AI Orchestrator

Responsibilities

- Agent Coordination
- Prompt Routing
- Context Building
- Response Aggregation

Owns

- AI Job
- AI Session
- AI Request

---

## AI Generation

Responsibilities

- Backend Generation
- Test Generation
- Documentation
- Refactoring

Owns

- Generation Plan
- Generated Artifact

---

## AI Review

Responsibilities

- Code Review
- Security Review
- Performance Review

Owns

- Review
- Finding
- Recommendation

---

# Integration Contexts

## GitHub

Responsibilities

- Repository Import
- Pull Requests
- Webhooks
- Branches

Owns

- Git Repository
- Pull Request
- Webhook Event

---

## External Integration

Responsibilities

- Jira
- Azure DevOps
- Slack
- Teams

Acts as an Anti-Corruption Layer (ACL) between ASEP and external systems.

---

# Context Relationships

| Context | Depends On |
|----------|------------|
| Organization | Identity |
| Project | Organization |
| Requirement | Project |
| Workflow | Requirement |
| Architecture | Requirement |
| Engineering Asset | Architecture |
| AI Orchestrator | Engineering Asset |
| GitHub | Project |
| Knowledge Graph | Engineering Asset |

---

# Dependency Rules

Bounded contexts must follow these rules.

Allowed

- REST APIs
- Published Interfaces
- Domain Events

Not Allowed

- Direct Database Access
- Shared JPA Entities
- Internal Package Access
- Circular Dependencies

---

# Ownership Rules

Each aggregate belongs to exactly one bounded context.

Only the owning bounded context may:

- Persist it
- Modify it
- Validate it
- Publish lifecycle events

Other contexts interact only through contracts.

---

# Future Contexts

Future releases may introduce:

- Marketplace
- Plugin Framework
- Portfolio Management
- Compliance
- Multi-Tenant Administration
- AI Learning
- Billing

---

# Summary

The bounded contexts establish the architectural boundaries of ASEP.

These boundaries enable modular development, preserve business ownership, and ensure that the platform can evolve from a modular monolith into independently deployable services without significant redesign.

---

# Related Documents

- SAD-001 – Software Architecture Overview
- SAD-004 – System Context
- SAD-006 – Module Architecture

---

# Change History

| Version | Date | Description |
|----------|------|-------------|
| 1.0 | 2026-07-02 | Initial Version |