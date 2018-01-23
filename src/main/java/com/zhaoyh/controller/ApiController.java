package com.zhaoyh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public String calculate(@RequestParam(name = "num") int num) {
        LOG.info(port + " get access...");
        int result = fib(num);
        return port + " calculate fib(" + num + ") = " + result;
    }

    /**
     * 计算fib结果
     * @param n
     * @return
     */
    private int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
