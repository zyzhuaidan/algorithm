package com.xingzhou.config.mq;


import org.apache.rocketmq.client.producer.SendResult;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName MQSender.java
 * @Description TODO
 * @createTime 2022年04月05日 19:29:00
 */
public interface MQSender{
    /**
     * 发送消息
     *
     * @param message 消息信息
     * @param topic   主题
     * @return 发送结果
     */
    SendResult sendMessage(Object message, String topic);
    /**
     * 发送消息
     *
     * @param message 消息信息
     * @param topic   主题
     * @param tags    主题的标签
     * @return 发送结果
     */
    SendResult sendMessage(Object message, String topic, String tags);
}