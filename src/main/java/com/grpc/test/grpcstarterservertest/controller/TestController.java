package com.grpc.test.grpcstarterservertest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author junqiang.xiao@hand-china.com
 * @date 2018/5/7
 */
@RestController
public class TestController {


    @RequestMapping("/reply")
    ResponseEntity test(String name) {
        return ResponseEntity.ok("Hello " + name);

    }
}
