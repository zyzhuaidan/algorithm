package com.xingzhou.config.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName SyncListener.java
 * @Description TODO
 * @createTime 2022年03月31日 15:23:00
 */
@Slf4j
@Component
@Order(1)
public class SyncListener {


    @Async
    @EventListener(BusinessEvent.class)
    public void createSuccess(BusinessEvent businessEvent) {
        Event eventData = businessEvent.getEventData();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("f data" + eventData.getName());
        log.info("receive event data --> {}", eventData.getName());
    }

}
