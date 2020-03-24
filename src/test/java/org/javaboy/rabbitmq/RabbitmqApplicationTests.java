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
     * direct交换机接收到这个消息的时候会转发到hello.javaboy为名称的队列消费者处理程序上去
     */
    @Test
    void direct() {
        rabbitTemplate.convertAndSend("hello.javaboy", "hello receiver, i need you to handle me.");
    }

    /**
     * fanout交换机接收到这个消息之后会转发到与之绑定的所有的队列上面去，从而消费队列中的消息
     */
    @Test
    void fanout(){
        rabbitTemplate.convertAndSend("javaboy-fanout", null, "hello fanout, i need you to handle me.");
    }
}
