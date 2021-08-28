package com.thuctapcdit.qlnguyenlieube.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String QUEUE1 = "message_noti";
    public static final String EXCHANGE1 = "exchange_noti";
    public static final String ROUTING_KEY1 = "routingKey_noti";

    public static final String QUEUE2 = "message_reset";
    public static final String EXCHANGE2 = "exchange_reset";
    public static final String ROUTING_KEY2 = "routingKey_reset";

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE1);
    }


    @Bean
    public TopicExchange exchange1() {
        return new TopicExchange(EXCHANGE1);
    }

    @Bean
    public Binding binding1(@Qualifier("queue1") Queue queue, @Qualifier("exchange1") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY1);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE2);
    }


    @Bean
    public TopicExchange exchange2() {
        return new TopicExchange(EXCHANGE2);
    }

    @Bean
    public Binding binding2(@Qualifier("queue2") Queue queue, @Qualifier("exchange2") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY2);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
