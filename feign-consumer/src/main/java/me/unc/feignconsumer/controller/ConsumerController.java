package me.unc.feignconsumer.controller;

import me.unc.feignconsumer.domain.User;
import me.unc.feignconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/feign-hello")
    public String helloConsumer() {
        return helloService.hello();
    }

    //=======================Request参数请求测试==========================

    @GetMapping("/feign-hello2")
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello("cxk")).append("\n");
        sb.append(helloService.hello("cxk", 20)).append("\n");
        sb.append(helloService.hello(new User("cxk", 20))).append("\n");
        return sb.toString();
    }

}
