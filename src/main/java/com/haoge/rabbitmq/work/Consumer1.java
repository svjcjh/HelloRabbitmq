package com.haoge.rabbitmq.work;

import com.haoge.rabbitmq.util.MQFactory;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = MQFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);
        channel.queueDeclare("work",false,false,false,null);

        channel.basicConsume("work",false,new DefaultConsumer(channel) {
           @Override
           public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
               System.out.println("消费者1 ---> " + new String(body));
               channel.basicAck(envelope.getDeliveryTag(),false);
           }
        });
    }
}
