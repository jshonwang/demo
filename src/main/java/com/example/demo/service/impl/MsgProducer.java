//package com.example.demo.service.impl;
//import com.example.demo.configuration.rabbitConig;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.UUID;
//
//@Component
//public class MsgProducer implements RabbitTemplate.ConfirmCallback {
//    private final Logger logger  = LoggerFactory.getLogger(MsgProducer.class);
////典型的约定大于声明
//    private RabbitTemplate rabbitTemplate;
//    public MsgProducer(RabbitTemplate rabbitTemplate){
//        this.rabbitTemplate = rabbitTemplate;
//        rabbitTemplate.setConfirmCallback(this);
//    }
//
//    public void sendMsg(String content){
//        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
//        rabbitTemplate.convertAndSend(rabbitConig.EXCHANGE_A,rabbitConig.ROUTINGKEY_A,content,correlationData);
//    }
//    public void sendMsgFanout(String content){
//        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
//        rabbitTemplate.convertAndSend(rabbitConig.EXCHANGE_Fanout,"",content,correlationData);
//    }
//    @Override
//    public void confirm(CorrelationData correlationData, boolean b, String s) {
//
//        logger.info("回调"+correlationData);
//
//        if(b){
//            logger.info("消费成功");
//        }else{
//            logger.info("消费失败"+s);
//        }
//
//
//
//    }
//
//    public static void main(String[] args) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate();
//        MsgProducer msgProducer = new MsgProducer(rabbitTemplate);
//        msgProducer.sendMsg("啦啦啦");
//
//    }
//}
