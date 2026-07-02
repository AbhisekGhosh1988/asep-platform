# SAD-012 – Technology Stack

---

# Document Information

| Property | Value |
|----------|-------|
| Document ID | SAD-012 |
| Document Name | Technology Stack |
| Product | ASEP (AI Software Engineering Platform) |
| Version | 1.0 |
| Status | Approved |
| Owner | Architecture Team |
| Author | Abhisek Ghosh |
| Created | 2026-07-02 |
| Last Updated | 2026-07-02 |

---

# Executive Summary

This document defines the approved technology stack for ASEP.

Only approved technologies should be used unless an Architecture Decision Record (ADR) approves an exception.

The primary objective is to ensure consistency, maintainability, long-term support, and enterprise readiness.

---

# Technology Principles

The technology stack should:

- Prefer mature and well-supported technologies.
- Minimize unnecessary dependencies.
- Favor open standards.
- Support long-term maintenance.
- Align with enterprise development practices.
- Enable modular evolution.

---

# Programming Language

| Category | Standard |
|----------|----------|
| Language | Java 21 LTS |
| Build Tool | Maven 3.9+ |
| Encoding | UTF-8 |

---

# Frameworks

| Category | Standard |
|----------|----------|
| Framework | Spring Boot 3.5.x |
| Architecture | Spring Modulith |
| Security | Spring Security |
| Validation | Jakarta Validation |
| Scheduling | Spring Scheduler |

---

# Persistence

| Category | Standard |
|----------|----------|
| ORM | Spring Data JPA |
| ORM Provider | Hibernate 6.x |
| Database | PostgreSQL |
| Migration | Flyway |
| Connection Pool | HikariCP |

---

# API Standards

| Category | Standard |
|----------|----------|
| API Style | REST |
| Specification | OpenAPI 3 |
| Serialization | Jackson |
| Documentation | springdoc-openapi |

---

# AI Stack

| Category | Standard |
|----------|----------|
| AI Client | Spring AI |
| LLM Providers | OpenAI Compatible |
| Local Models | Ollama |
| Prompt Management | Internal Prompt Registry |
| Embeddings | Provider Agnostic |
| MCP | Planned |

---

# Git Integration

| Category | Standard |
|----------|----------|
| Git Library | JGit |
| Git Provider | GitHub |
| Future Support | GitLab, Bitbucket |

---

# Testing

| Category | Standard |
|----------|----------|
| Unit Testing | JUnit 5 |
| Mocking | Mockito |
| Integration Testing | Spring Boot Test |
| Containers | Testcontainers |
| Architecture Testing | Spring Modulith Test |

---

# Observability

| Category | Standard |
|----------|----------|
| Metrics | Micrometer |
| Monitoring | Prometheus |
| Dashboard | Grafana |
| Tracing | OpenTelemetry |
| Logging | SLF4J + Logback |

---

# Documentation

| Category | Standard |
|----------|----------|
| Documentation | Markdown |
| UML | PlantUML |
| ADR | Markdown |
| API | OpenAPI |

---

# Security

| Category | Standard |
|----------|----------|
| Authentication | OAuth2 |
| Authorization | RBAC |
| Token | JWT |
| Password Hashing | BCrypt |
| Secrets | Environment / Vault |

---

# Build & Quality

| Category | Standard |
|----------|----------|
| Build | Maven |
| Static Analysis | SpotBugs |
| Formatting | Spotless |
| Code Style | Google Java Style (adapted) |

---

# Approved Libraries

- Lombok
- MapStruct
- Apache Commons
- Jackson
- Spring AI
- JGit

---

# Restricted Technologies

The following require explicit architecture approval:

- Reflection-heavy frameworks
- Proprietary ORM libraries
- Direct JDBC in business modules
- Framework-specific business logic
- Unmaintained open-source libraries

---

# Upgrade Strategy

- Prefer LTS releases.
- Upgrade dependencies quarterly.
- Review security advisories monthly.
- Maintain backward compatibility where feasible.

---

# Summary

ASEP adopts a modern, enterprise-grade technology stack focused on stability, modularity, extensibility, and long-term maintainability.

---

# Related Documents

- SAD-001 – Software Architecture Overview
- SAD-011 – Quality Attributes
- SAD-014 – Architecture Decision Summary

---

# Change History

| Version | Date | Description |
|----------|------|-------------|
| 1.0 | 2026-07-02 | Initial Version |