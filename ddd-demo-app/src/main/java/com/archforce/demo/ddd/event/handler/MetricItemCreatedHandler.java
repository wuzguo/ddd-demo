package com.archforce.demo.ddd.event.handler;


import com.alibaba.cola.dto.Response;
import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import com.archforce.demo.ddd.api.IUserProfileService;
import com.archforce.demo.ddd.dto.RefreshScoreCmd;
import com.archforce.demo.ddd.dto.domainevent.MetricItemCreatedEvent;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Zak
 */

@Slf4j
@EventHandler
public class MetricItemCreatedHandler implements EventHandlerI<Response, MetricItemCreatedEvent> {

    @Resource
    private IUserProfileService userProfileService;

    @Override
    public Response execute(MetricItemCreatedEvent event) {
        log.debug("Handling Event: " + event);
        RefreshScoreCmd cmd = new RefreshScoreCmd(event.getUserId());
        userProfileService.refreshScore(cmd);
        return Response.buildSuccess();
    }
}
