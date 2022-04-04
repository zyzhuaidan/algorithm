package com.xingzhou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/hello")
    public String hello()  {
        return "hello";
    }

}
