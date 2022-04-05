package com.xingzhou.config.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName BusinessListener.java
 * @Description TODO
 * @createTime 2022年04月05日 10:48:00
 */
@Component
public class BusinessListener implements ApplicationListener<BusinessEvent> {

    /**
     * 监听到事件后做的处理
     * @param event
     */
    @Override
    public void onApplicationEvent(BusinessEvent event) {
        System.out.println("监听到事件：" + event.getEventData().getId());
    }
}