package org.javaboy.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitTopicConfig
 *
 * @author arctic
 * @date 2020/3/24
 **/
@Configuration
public class RabbitTopicConfig {

    public final static String TOPICNAME = "javaboy-topic";

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPICNAME, true, false);
    }

    //----三个队列

    @Bean
    Queue xiaomi(){
        return new Queue("xiaomi");
    }

    @Bean
    Queue huawei(){
        return new Queue("huawei");
    }

    @Bean
    Queue phone(){
        return new Queue("phone");
    }

    //----队列绑定

    @Bean
    Binding xiaomiBinding(){
        return BindingBuilder.bind(xiaomi()).to(topicExchange()).with("xiaomi.#");
    }

    @Bean
    Binding huaweiBinding(){
        return BindingBuilder.bind(huawei()).to(topicExchange()).with("huawei.#");
    }

    @Bean
    Binding phoneBinding(){
        return BindingBuilder.bind(phone()).to(topicExchange()).with("#.phone.#");
    }
}
