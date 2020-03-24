package org.javaboy.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * TopicReceiver
 *
 * @author arctic
 * @date 2020/3/24
 **/
@Component
public class TopicReceiver {

    @RabbitListener(queues = "xiaomi")
    public void xiaomi(String msg){
        System.out.println("TopicReceiver.xiaomi>>>>"+msg);
    }

    @RabbitListener(queues = "huawei")
    public void huawei(String msg){
        System.out.println("TopicReceiver.huawei>>>>"+msg);
    }

    @RabbitListener(queues = "phone")
    public void phone(String msg){
        System.out.println("TopicReceiver.phone>>>>"+msg);
    }
}
