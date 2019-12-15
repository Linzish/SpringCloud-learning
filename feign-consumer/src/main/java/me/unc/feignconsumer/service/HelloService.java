package me.unc.feignconsumer.service;

import me.unc.feignconsumer.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/*
通过@FeignClient注解指定服务名来绑定服务
fallback参数指定服务降级逻辑
 */
@FeignClient(name = "hello-service", fallback = HelloServiceFallback.class)
public interface HelloService {

    @GetMapping("/hello")
    String hello();

    //=======================Request参数请求测试==========================

    @GetMapping("/hello1")
    String hello(@RequestParam String name);

    @GetMapping("/hello2")
    User hello(@RequestHeader String name, @RequestHeader int age);

    @GetMapping("/hello3")
    String hello(@RequestBody User user);

}
