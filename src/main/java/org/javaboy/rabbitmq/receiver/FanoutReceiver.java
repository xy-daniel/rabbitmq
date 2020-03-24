package org.javaboy.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * FanoutReceiver
 *
 * @author arctic
 * @date 2020/3/24
 **/
@Component
public class FanoutReceiver {

    /**
     * 处理队列中的消息
     *
     * @param msg 收到的消息
     */
    @RabbitListener(queues = "queue-one")
    public void handleOne(String msg) {
        System.out.println("FanoutReceiver.handleOne>>>>" + msg);
    }

    /**
     * 处理队列中的消息
     *
     * @param msg 收到的消息
     */
    @RabbitListener(queues = "queue-two")
    public void handleTwo(String msg) {
        System.out.println("FanoutReceiver.handleTwo>>>>" + msg);
    }
}
