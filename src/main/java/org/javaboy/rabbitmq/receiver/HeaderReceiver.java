package org.javaboy.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * HeaderReceiver
 *
 * @author arctic
 * @date 2020/3/24
 **/
@Component
public class HeaderReceiver {

    @RabbitListener(queues = "name-queue")
    public void handle1(byte[] msg) {
        System.out.println("HeaderReceiver.handle1>>>>" + new String(msg, 0, msg.length));
    }

    @RabbitListener(queues = "age-queue")
    public void handle2(byte[] msg) {
        System.out.println("HeaderReceiver.handle2>>>>" + new String(msg, 0, msg.length));
    }

}
