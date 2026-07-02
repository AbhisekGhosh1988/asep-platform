# DM-018 – Billing Domain

---

# Document Information

| Property | Value |
|----------|-------|
| Document ID | DM-018 |
| Document Name | Billing Domain |
| Product | ASEP (AI Software Engineering Platform) |
| Version | 1.0 |
| Status | Approved |

---

# Executive Summary

The Billing Domain manages subscriptions, pricing plans, usage metering, invoicing, and payments for the ASEP SaaS platform.

The domain is isolated from engineering functionality and focuses exclusively on commercial operations.

---

# Responsibilities

- Subscription Management
- Pricing Plans
- Usage Metering
- Invoicing
- Payment Tracking
- License Management

---

# Aggregate Root

Subscription

---

# Child Entities

PricingPlan

Invoice

InvoiceLine

Payment

UsageRecord

License

Coupon

---

# Value Objects

SubscriptionId

InvoiceId

PaymentId

PlanCode

Currency

BillingPeriod

---

# Domain Services

SubscriptionService

UsageMeteringService

InvoiceService

PaymentService

LicenseService

---

# Domain Events

SubscriptionCreated

SubscriptionUpgraded

SubscriptionCancelled

InvoiceGenerated

InvoicePaid

PaymentFailed

UsageRecorded

LicenseActivated

---

# Business Rules

- One active subscription per organization.
- Usage is metered continuously.
- Invoices are immutable after generation.
- Failed payments trigger retries.
- Licenses define platform capabilities.
- Billing history is retained permanently.

---

# Pricing Models

- Free
- Professional
- Business
- Enterprise
- Custom Enterprise

---

# Public APIs

Create Subscription

Upgrade Plan

View Usage

Generate Invoice

Record Payment

Download Invoice

---

# Repository

SubscriptionRepository

InvoiceRepository

PaymentRepository

---

# Module

platform-billing

---

# Summary

The Billing Domain enables ASEP to operate as a commercial SaaS platform while remaining independent from engineering domains.

---

# Related Documents

PB-004 – Product Scope

PB-008 – Product Roadmap

---

# Change History

| Version | Date | Description |
|----------|------|-------------|
|1.0|2026-07-02|Initial Version|