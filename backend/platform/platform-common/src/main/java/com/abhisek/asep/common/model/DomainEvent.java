package com.abhisek.asep.common.model;

import java.time.Instant;

public interface DomainEvent {

    Instant occurredOn();

}