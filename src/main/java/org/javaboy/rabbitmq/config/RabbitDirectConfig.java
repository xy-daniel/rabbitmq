package org.javaboy.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitDirectConfig
 *
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/23 22:37
 */
@Configuration
public class RabbitDirectConfig {
    public final static String DIRECTNAME = "javaboy-direct";

    /**
     * 队列---->以hello.javaboy命名
     */
    @Bean
    Queue queue(){
        return new Queue("hello.javaboy");
    }

    /**
     * Direct交换机  根据路由键进行处理---->即仅处理hello.javaboy队列中的消息
     */
    @Bean
    DirectExchange directExchange(){
        //重启后依然有效，长期未使用不要删除
        return new DirectExchange(DIRECTNAME, true, false);
    }

    /**
     * 将上面的两个绑定在一起
     */
    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }

    //---使用directExchange上面最近的两个可以省略不写，但是其他的模式需要使用到这两个Bean
}
