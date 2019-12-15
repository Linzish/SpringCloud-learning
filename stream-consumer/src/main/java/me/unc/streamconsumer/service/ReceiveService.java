package me.unc.streamconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class ReceiveService {

    private static Logger logger = LoggerFactory.getLogger(ReceiveService.class);

    @StreamListener(Sink.INPUT)   //INPUT是管道名称，要与配置文件中对应
    public void receive(Object payload) {
        System.out.println("Receive " + payload);
        logger.info("ReceiveService receive was call --Receive message [ " + payload + " ]");
    }

}
