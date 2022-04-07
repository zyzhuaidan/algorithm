package com.xingzhou.config.mq;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName RocketMqSender.java
 * @Description TODO
 * @createTime 2022年04月05日 19:30:00
 */

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Slf4j
@Component
public class RocketMqSender implements MQSender {
    @Value("${rocketmq.name-server}")
    private String nameServer;
    @Value("${rocketmq.producer.timeout}")
    private int timeout;
    @Value("${spring.application.name}")
    private String group;
    private DefaultMQProducer producer;

    @PostConstruct
    public void init() {
        producer = new DefaultMQProducer(group);
        try {
            producer.setNamesrvAddr(nameServer);
            producer.setSendMsgTimeout(timeout);
            producer.start();
            log.info("RocketMQ Producer启动成功! nameServer={}, group={}", nameServer, group);
        } catch (MQClientException e) {
            log.error("RocketMQ Producer启动失败! nameServer={}, group={} ", nameServer, group, e);
        }
    }

    @Override
    public SendResult sendMessage(Object message, String topic) {
        try {
            Message msg = new Message(topic, JSON.toJSONBytes(message));
            SendResult sendResult = producer.send(msg);
            log.info("发送MQ成功：sendResult={},message={}", sendResult, message.toString());
            return sendResult;
        } catch (Exception e) {
            log.error("消息发送失败, topic:{}, message:{}", topic, message, e);
        }
        return null;
    }

    @Override
    public SendResult sendMessage(Object message, String topic, String tags) {
        try {
            Message msg = new Message(topic, tags, JSON.toJSONBytes(message));
            SendResult sendResult = producer.send(msg);
            log.info("发送MQ成功：sendResult={},message={}", sendResult, message.toString());
            return sendResult;
        } catch (Exception e) {
            log.error("消息发送失败, topic:{}, tags:{}, message:{}", topic, tags, message, e);
        }
        return null;
    }
}