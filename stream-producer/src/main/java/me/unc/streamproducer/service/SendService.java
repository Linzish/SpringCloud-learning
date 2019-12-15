package me.unc.streamproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

//使用@EnableBinding注解绑定消息通道，类型为Source，表示输出，还有Sink，代表输入，Process代表输入输出
@EnableBinding(Source.class)
public class SendService {

    @Autowired
    private Source source;

    public void sendMsg(String msg) {
        //使用MessageBuilder创建消息
        source.output().send(MessageBuilder.withPayload(msg).build());
    }

}
