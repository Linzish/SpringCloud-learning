package me.unc.streamproducer.controller;

import me.unc.streamproducer.service.SendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private static Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private SendService sendService;

    @PostMapping("/send/{msg}")
    public void send(@PathVariable("msg") String msg){
        sendService.sendMsg(msg);
        logger.info("ProducerController send was call [send msg " + msg +" ]");
    }

}
