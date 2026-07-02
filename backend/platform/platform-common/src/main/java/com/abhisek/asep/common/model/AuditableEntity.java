package com.abhisek.asep.common.model;

import java.io.Serializable;
import java.time.Instant;

public abstract class AuditableEntity<ID extends Serializable> extends BaseEntity<ID> {

    private Instant createdAt;

    private Instant updatedAt;

    private String createdBy;

    private String updatedBy;

    protected AuditableEntity() {
    }

    protected AuditableEntity(ID id) {
        super(id);
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}