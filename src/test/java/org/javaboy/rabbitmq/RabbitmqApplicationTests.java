package org.javaboy.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * directExchange接收到这个消息的时候会转发到routingKey以hello.javaboy为名称的队列消费者处理程序上去
     */
    @Test
    void product1() {
        rabbitTemplate.convertAndSend("hello.javaboy", "hello receiver, i need you to handle me.");
    }

}
