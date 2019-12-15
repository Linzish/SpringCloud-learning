package me.unc.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableConfigServer   //开启配置中心功能
@SpringBootApplication
public class ConfigServerApplication {

    //     /actuator/bus-refresh 刷新配置url
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
