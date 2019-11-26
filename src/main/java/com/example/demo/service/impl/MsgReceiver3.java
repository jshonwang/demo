package com.example.demo.service.impl;

import com.example.demo.configuration.rabbitConig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = rabbitConig.QUEUE_C)
public class MsgReceiver3 {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RabbitHandler
    public void process(String content){
        logger.info("接受Two处理消息队列C中的信息"+content);

    }
}
