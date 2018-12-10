package com.zhaoyh.controller;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/testZuul")
    public String testZuul() {
        return "zuul->server " + port;
    }

    @GetMapping(value = "/calculate")
    public String calculate(@RequestParam(name = "num") int num) throws InterruptedException {
        LOG.info(port + " get access...");
        int result = fib(num);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", result);
        jsonObject.addProperty("port", port);
        // Thread.sleep(6000);
        return jsonObject.toString();
    }

    /**
     * 计算fib结果
     * @param n
     * @return
     */
    private int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
