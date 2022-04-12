package com.archforce.demo.ddd.common.event;

import com.alibaba.cola.event.DomainEventI;
import com.alibaba.cola.event.EventBusI;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * DomainEventPublisher, this is for demo purpose, the Event is sent to EventBus
 * <p>
 * Normally DomainEvent should be sent to Messaging Middleware
 *
 * @author Frank Zhang
 * @date 2019-01-04 11:05 AM
 */
@Component
public class DomainEventPublisher {

    @Resource
    private EventBusI eventBus;

    public void publish(DomainEventI domainEvent) {
        eventBus.fire(domainEvent);
    }
}