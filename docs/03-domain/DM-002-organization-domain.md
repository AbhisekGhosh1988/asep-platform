# DM-002 – Organization Domain

---

# Executive Summary

The Organization Domain manages organizations, subscriptions, memberships, and organizational settings.

Every project belongs to exactly one organization.

---

# Aggregate Root

Organization

---

# Entities

- Organization
- Membership
- OrganizationSettings
- Subscription

---

# Value Objects

- OrganizationId
- OrganizationName
- SubscriptionPlan

---

# Domain Services

OrganizationManagementService

MembershipService

SubscriptionService

---

# Domain Events

OrganizationCreated

OrganizationUpdated

MemberInvited

MemberJoined

SubscriptionChanged

---

# Business Rules

- Organization name must be unique.
- Organization owns all workspaces.
- Organization owns projects.
- Organization owns engineering assets.
- One subscription per organization.

---

# Repositories

OrganizationRepository

MembershipRepository

SubscriptionRepository

---

# Public APIs

Create Organization

Update Organization

Invite Member

Manage Subscription

---

# Module

platform-organization