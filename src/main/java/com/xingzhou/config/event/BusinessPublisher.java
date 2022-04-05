package com.xingzhou.config.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName BusinessPublisher.java
 * @Description spring事件监听机制中的"事件发布器"
 * @createTime 2022年04月05日 10:49:00
 */
@Component
public class BusinessPublisher implements ApplicationEventPublisherAware {

    /**
     * spring提供的事件发布组件
     */
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 发布事件
     */
    public void publishEvent(BusinessEvent businessEvent) {
        System.out.println("发布事件:" + businessEvent.getEventData().getId());
        this.applicationEventPublisher.publishEvent(businessEvent);
    }
}
