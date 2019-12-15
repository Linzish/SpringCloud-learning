package me.unc.serviceprovider.cotroller;

import me.unc.serviceprovider.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/hello")
    public String hello() {
        logger.info("service provider SERVICE-PROVIDE [hello] was call");
        return "Hello Spring Cloud";
    }

    //=====================Request参数请求测试==========================

    @GetMapping("/hello1")
    public String hello1(@RequestParam String name) {
        logger.info("service provider SERVICE-PROVIDE [hello1] was call");
        return "hello " + name;
    }

    @GetMapping("/hello2")
    public User hello2(@RequestHeader String name, @RequestHeader int age) {
        logger.info("service provider SERVICE-PROVIDE [hello2] was call");
        return new User(name, age);
    }

    @PostMapping("/hello3")
    public String hello3(@RequestBody User user) {
        return "hello " + user.toString();
    }

}
