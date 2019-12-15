package me.unc.ribbonconsumer.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import me.unc.ribbonconsumer.domain.User;
import me.unc.ribbonconsumer.service.HelloService;
import me.unc.ribbonconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String helloConsumer() {
        return helloService.hello();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") long id) {
        //初始化HystrixRequestContext
        if (!HystrixRequestContext.isCurrentThreadInitialized()) {
            HystrixRequestContext.initializeContext();
        }
        return userService.getUserById(id);
    }

}
