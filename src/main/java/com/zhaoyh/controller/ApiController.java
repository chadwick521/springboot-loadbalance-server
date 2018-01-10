package com.zhaoyh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaoyh on 2018/1/5
 * api service
 * @author zhaoyh
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/say")
    public String index() {
        LOG.info(port + " get access...");
        return port + " say hello!";
    }
}
