package com.abhisek.asep.common.event;

import java.time.Instant;

public interface DomainEvent {

    Instant occurredOn();

}