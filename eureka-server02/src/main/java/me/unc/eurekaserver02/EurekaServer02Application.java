package me.unc.eurekaserver02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心
 * 使用@EnableEurekaServer注解开启服务注册中心
 * 第二个服务中心，开启高可用
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer02Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer02Application.class, args);
    }

}
