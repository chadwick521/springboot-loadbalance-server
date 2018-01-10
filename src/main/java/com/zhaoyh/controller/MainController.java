package com.zhaoyh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhaoyh on 2018/1/2
 * @author zhaoyh
 */
@Controller
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        LOG.info("port: " + port);
        return "index";
    }
}
