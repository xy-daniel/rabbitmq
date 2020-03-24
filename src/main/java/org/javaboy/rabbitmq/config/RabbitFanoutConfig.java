package org.javaboy.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitFanoutConfig
 *
 * @author arctic
 * @date 2020/3/24
 **/
@Configuration
public class RabbitFanoutConfig {

    public final static String  FANOUTNAME = "javaboy-fanout";

    //----两个队列

    @Bean
    Queue queueOne(){
        return new Queue("queue-one");
    }

    @Bean
    Queue queueTwo(){
        return new Queue("queue-two");
    }

    /**
     * Fanout交换机  不根据路由键进行处理---->即仅处理hello.javaboy队列中的消息
     */
    @Bean
    FanoutExchange fanoutExchange(){
        //重启后依然有效，长期未使用不要删除
        return new FanoutExchange(FANOUTNAME, true, false);
    }

    //----队列绑定

    @Bean
    Binding bindingOne(){
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }

    @Bean
    Binding bindingTwo(){
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }

}
