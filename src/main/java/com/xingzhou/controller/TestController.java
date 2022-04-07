package com.xingzhou.controller;

import com.xingzhou.config.mq.OrderProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description TODO
 * @createTime 2022年04月04日 22:56:00
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private OrderProducer orderProducer;

    @GetMapping(value = "/hello")
    public String hello()  {
        orderProducer.createOrder();
        return "hello";
    }

}
