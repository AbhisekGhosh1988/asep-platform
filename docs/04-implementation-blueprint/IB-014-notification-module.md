# IB-014 – Notification Module

---

Module

platform-notification

---

Responsibilities

- Notification Management
- Email Delivery
- In-App Notifications
- Slack Integration
- Teams Integration

---

Aggregate

Notification

---

Entities

Notification

NotificationTemplate

NotificationChannel

Delivery

Preference

---

Repositories

NotificationRepository

TemplateRepository

---

Application Services

SendNotificationUseCase

RetryDeliveryUseCase

ManagePreferencesUseCase

---

Domain Services

NotificationService

DeliveryService

TemplateService

---

Controllers

NotificationController

PreferenceController

---

Events

NotificationCreated

NotificationDelivered

NotificationFailed

---

Compilation Metadata

Priority: SUPPORT

Generation Order: 9

---

Generation Contract

Generate

Notification APIs

Email adapters

Templates

Tests

Preserve

Custom notification providers