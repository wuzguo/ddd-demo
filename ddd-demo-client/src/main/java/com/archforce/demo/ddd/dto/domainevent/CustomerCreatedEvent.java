package com.archforce.demo.ddd.dto.domainevent;

import com.alibaba.cola.event.DomainEventI;
import lombok.Data;

/**
 * CustomerCreatedEvent
 *
 * @author Frank Zhang
 * @date 2019-01-04 10:32 AM
 */

@Data
public class CustomerCreatedEvent implements DomainEventI {

    /**
     * 客户ID
     */
    private String customerId;
}
