package com.archforce.demo.ddd.dto.domainevent;

import com.alibaba.cola.event.DomainEventI;
import lombok.Data;

/**
 * @author Zak
 */

@Data
public class MetricItemCreatedEvent implements DomainEventI {

    private String id;

    private String userId;

    private String mainMetricType;
}
