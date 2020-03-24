package org.javaboy.rabbitmq;

import org.javaboy.rabbitmq.config.RabbitHeaderConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
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

    @Test
    void topic(){
        rabbitTemplate.convertAndSend("javaboy-topic", "xiaomi.news", "小米新闻");
        rabbitTemplate.convertAndSend("javaboy-topic", "huawei.news", "华为新闻");
        rabbitTemplate.convertAndSend("javaboy-topic", "phone.news", "phone新闻_after");
        rabbitTemplate.convertAndSend("javaboy-topic", "news.phone", "phone新闻_before");
        rabbitTemplate.convertAndSend("javaboy-topic", "news.phone.news", "phone新闻_after_before");
        rabbitTemplate.convertAndSend("javaboy-topic", "xiaomi.phone", "小米phone");
        rabbitTemplate.convertAndSend("javaboy-topic", "huawei.phone", "华为phone");
        rabbitTemplate.convertAndSend("javaboy-topic", "vivo.news", "vivo新闻");
    }

    @Test
    void header(){
        Message nameMessage = MessageBuilder.withBody("hello javaboy".getBytes()).setHeader("name", "javaboy").build();
        Message errorMessage = MessageBuilder.withBody("hello javaboy".getBytes()).setHeader("name", "ddg").build();
        Message ageMessage = MessageBuilder.withBody("hello 99".getBytes()).setHeader("age", "99").build();
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME, null, nameMessage);
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME, null, errorMessage);
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME, null, ageMessage);
    }
}
