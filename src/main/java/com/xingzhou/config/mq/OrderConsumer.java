package com.xingzhou.config.mq;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName OrderConsumer.java
 * @Description TODO
 * @createTime 2022年04月05日 19:38:00
 */
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "TEMP-GROUP", topic = "TEMP")
public class OrderConsumer implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt messageExt) {
        String message = new String(messageExt.getBody());
        log.info("收到消息，topic:{}, tag:{}, msgId:{}, body:{}", messageExt.getTopic(), messageExt.getTags(),
                messageExt.getMsgId(), message);
    }
}