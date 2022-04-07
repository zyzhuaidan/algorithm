package com.xingzhou.config.mq;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName OrderProducer.java
 * @Description TODO
 * @createTime 2022年04月05日 19:37:00
 */
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class OrderProducer {
    @Resource
    private MQSender mqSender;
    public void createOrder() {
        mqSender.sendMessage("我是注册订单，请尽快处理", "TEMP");
    }}