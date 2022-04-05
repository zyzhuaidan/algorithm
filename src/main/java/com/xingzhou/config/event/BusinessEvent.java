package com.xingzhou.config.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName BusinessEvent.java
 * @Description spring监听机制中的"事件"
 * @createTime 2022年04月05日 08:21:00
 */
public class BusinessEvent extends ApplicationEvent {

    /**
     * 该类型事件携带的信息
     */
    private Event eventData;

    public BusinessEvent( Object source) {
        super(source);
    }
    /**
     *
     * @param source 最初触发该事件的对象
     * @param eventData 该类型事件携带的信息
     */
    public BusinessEvent(Object source, Event eventData) {
        super(source);
        this.eventData = eventData;
    }

    public Event getEventData(){
        return eventData;
    }
}
