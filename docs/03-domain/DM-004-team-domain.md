# DM-004 – Team Domain

---

# Executive Summary

Teams organize users around engineering responsibilities.

A user may belong to multiple teams.

Teams are used for workflow assignment, notifications, approvals, and reporting.

---

# Aggregate Root

Team

---

# Entities

Team

TeamMember

TeamRole

---

# Value Objects

TeamId

TeamName

---

# Domain Services

TeamManagementService

AssignmentService

---

# Events

TeamCreated

TeamUpdated

MemberAssigned

MemberRemoved

---

# Business Rules

- Team belongs to one workspace.
- Team may own projects.
- User may belong to multiple teams.
- Team Lead approves assignments.

---

# Repository

TeamRepository

---

# APIs

Create Team

Assign Member

Remove Member

List Members

---

# Module

platform-organization