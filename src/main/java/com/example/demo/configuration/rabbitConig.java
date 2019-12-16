//package com.example.demo.configuration;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//@Configuration
//public class rabbitConig {
//    private final  Logger logger = LoggerFactory.getLogger(rabbitConig.class);
//    @Value("${spring.rabbitmq.host}")
//    private String host;
//    @Value("${spring.rabbitmq.port}")
//    private int port;
//    @Value("${spring.rabbitmq.username}")
//    private String username;
//    @Value("${spring.rabbitmq.password}")
//    private String password;
//
//
//    public static final String EXCHANGE_A = "my-mq-exchange_A";
//    public static final String EXCHANGE_B = "my-mq-exchange_B";
//    public static final String EXCHANGE_C = "my-mq-exchange_C";
//
//    public static final String EXCHANGE_Fanout = "Fanout";
//
//
//    public static final String QUEUE_A = "QUEUE_A";
//    public static final String QUEUE_B = "QUEUE_B";
//    public static final String QUEUE_C = "QUEUE_C";
//
//    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";
//    public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
//    public static final String ROUTINGKEY_C = "spring-boot-routingKey_C";
//
//
//    @Bean
//    public DirectExchange defaultExchange(){
//        return new DirectExchange(EXCHANGE_A);
//    }
//    @Bean
//    public FanoutExchange fanoutExchange(){
//        return new FanoutExchange(EXCHANGE_Fanout);
//    }
//    @Bean
//    public Queue queueA(){
//        return new Queue(QUEUE_A,true);   //队列持久
//    }
//    @Bean
//    public Queue queueB(){
//        return new Queue(QUEUE_B,true);   //队列持久
//    }
//
//    @Bean
//    public Queue queueC(){
//        return new Queue(QUEUE_C,true);
//    }
//
//    @Bean
//    public Binding binding(){
//        return BindingBuilder.bind(queueA()).to(fanoutExchange());
//    }
//    @Bean
//    public Binding bindingB(){
//        return BindingBuilder.bind(queueB()).to(fanoutExchange());
//    }
//    @Bean
//    public Binding bindingC(){
//        return BindingBuilder.bind(queueC()).to(fanoutExchange());
//    }
//
//
//    public ConnectionFactory connectionFactory(){
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
//        connectionFactory.setPassword(password);
//        connectionFactory.setUsername(username);
//        connectionFactory.setVirtualHost("/");
//        connectionFactory.setPublisherConfirms(true);
//        return connectionFactory;
//    }
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    //必须是prototype类型
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory());
//        return template;
//    }
//
//
//
//
//}
