package com.example.demo.controller;

import com.example.demo.service.impl.MsgProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MsgProducer msgProducer;
    @RequestMapping("/send")
    public void sendMsg(){
        msgProducer.sendMsgFanout("拉拉阿拉");

    }

}
