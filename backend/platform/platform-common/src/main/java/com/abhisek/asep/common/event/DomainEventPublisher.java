package com.abhisek.asep.common.event;

public interface DomainEventPublisher {

    void publish(DomainEvent event);

}