package com.example.demo.service.impl;

import com.example.demo.configuration.rabbitConig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = rabbitConig.QUEUE_A)
public class MsgReceiver {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RabbitHandler
    public void process(String content){
        logger.info("接受One处理消息队列A中的信息"+content);

    }
}
