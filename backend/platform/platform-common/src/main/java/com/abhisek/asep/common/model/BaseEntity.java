package com.abhisek.asep.common.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class BaseEntity<ID extends Serializable> {

    private ID id;

    protected BaseEntity() {
    }

    protected BaseEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    protected void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (!(o instanceof BaseEntity<?> other))
            return false;

        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
