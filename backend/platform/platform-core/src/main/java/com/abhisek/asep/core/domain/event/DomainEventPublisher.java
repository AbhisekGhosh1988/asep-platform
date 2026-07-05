package com.abhisek.asep.core.domain.event;

public interface DomainEventPublisher {

    void publish(Object event);

}