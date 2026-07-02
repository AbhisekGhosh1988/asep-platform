# SAD-004 – System Context

---

# Document Information

| Property | Value |
|----------|-------|
| Document ID | SAD-004 |
| Document Name | System Context |
| Product | ASEP (AI Software Engineering Platform) |
| Version | 1.0 |
| Status | Approved |
| Owner | Architecture Team |
| Author | Abhisek Ghosh |
| Created | 2026-07-02 |
| Last Updated | 2026-07-02 |

---

# Executive Summary

This document defines the system context for ASEP.

It identifies all external actors, external systems, integration boundaries, and the interactions between ASEP and its surrounding ecosystem.

The purpose of this document is to establish clear system boundaries before defining the internal architecture.

---

# System Overview

ASEP acts as the central Software Engineering Platform within an organization.

It orchestrates engineering activities across the Software Development Life Cycle (SDLC) while integrating with existing enterprise tools.

ASEP does not replace specialized engineering tools. Instead, it coordinates them and preserves engineering knowledge across the lifecycle.

---

# Primary Actors

The following actors interact directly with ASEP.

## Business Analyst

Responsible for:

- Creating requirements
- Defining business rules
- Maintaining requirement specifications

---

## Product Owner

Responsible for:

- Product planning
- Requirement prioritization
- Requirement approval
- Release approval

---

## Solution Architect

Responsible for:

- Architecture design
- Technical planning
- Architecture approval

---

## Developer

Responsible for:

- Code generation
- Business logic implementation
- Code review
- Pull Requests

---

## QA Engineer

Responsible for:

- Test planning
- Test execution
- Validation
- Quality assurance

---

## DevOps Engineer

Responsible for:

- Deployment
- Release pipelines
- Environment configuration

---

## Security Engineer

Responsible for:

- Security reviews
- Compliance
- Vulnerability analysis

---

## Engineering Manager

Responsible for:

- Governance
- Engineering metrics
- Team management
- Delivery oversight

---

## AI Agents

Responsible for assisting engineering activities including:

- Analysis
- Planning
- Generation
- Review
- Documentation

AI agents never own engineering decisions.

---

# External Systems

ASEP integrates with multiple enterprise platforms.

## Source Control

Examples:

- GitHub
- GitLab
- Bitbucket

Purpose:

- Repository synchronization
- Pull Requests
- Webhooks
- Branch management

---

## Project Management

Examples:

- Jira
- Azure DevOps

Purpose:

- Requirement synchronization
- Backlog management
- Sprint tracking

---

## Communication Platforms

Examples:

- Slack
- Microsoft Teams
- Email

Purpose:

- Notifications
- Reviews
- Approval requests

---

## Identity Providers

Examples:

- LDAP
- Active Directory
- OAuth2
- OpenID Connect
- SAML

Purpose:

- Authentication
- Single Sign-On
- User synchronization

---

## AI Providers

Examples:

- OpenAI
- Anthropic
- Google Gemini
- Azure OpenAI
- Ollama

Purpose:

- AI reasoning
- Code generation
- Analysis
- Documentation

---

# System Context Diagram

```
                           +----------------------+
                           | Business Analyst     |
                           +----------+-----------+
                                      |
                           +----------v-----------+
                           |                      |
                           |        ASEP          |
                           | AI Software         |
                           | Engineering Platform |
                           |                      |
+-----------+              +----------+-----------+             +-----------+
| GitHub    |<----------------------->|<----------------------->| Jira      |
+-----------+                         |                         +-----------+
                                      |
                                      |
                          +-----------+------------+
                          | AI Providers           |
                          | OpenAI / Ollama / etc. |
                          +-----------+------------+
                                      |
                                      |
                         +------------+------------+
                         | Identity Provider       |
                         | OAuth2 / LDAP / SSO     |
                         +-------------------------+
```

---

# System Boundary

ASEP owns:

- Engineering Assets
- Workflows
- AI Orchestration
- Knowledge Graph
- Engineering Governance
- Engineering Traceability

External systems remain responsible for their respective domains.

---

# Integration Principles

All integrations must satisfy the following principles:

- API-first
- Secure communication
- Loose coupling
- Retry mechanisms
- Auditability
- Version compatibility
- Failure isolation

---

# Responsibilities

ASEP is responsible for:

- Engineering lifecycle orchestration
- Engineering knowledge management
- AI-assisted engineering
- Governance
- Traceability

ASEP is not responsible for:

- Source code hosting
- CI/CD execution
- Cloud infrastructure
- Production monitoring
- Enterprise resource planning

---

# Summary

The System Context establishes ASEP as the central engineering platform that coordinates people, AI agents, and enterprise systems throughout the Software Development Life Cycle while preserving engineering knowledge and governance.

---

# Related Documents

- PB-006 – Personas & Roles
- PB-007 – Capability Map
- SAD-001 – Software Architecture Overview
- SAD-005 – Bounded Contexts

---

# Change History

| Version | Date | Description |
|----------|------|-------------|
| 1.0 | 2026-07-02 | Initial Version |