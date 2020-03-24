package org.javaboy.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * directExchange模式消费者
 *
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/23 22:50
 */
@Component
public class DirectReceiver {

    /**
     * 消费处理---->监听routingKey以hello.javaboy为名称的生产者（即对应队列）发送的消息并进行处理
     *
     * @param msg 待消费的字符串消息
     */
    @RabbitListener(queues = "hello.javaboy")
    public void handler(String msg) {
        System.out.println("handler>>>>" + msg);
    }
}
