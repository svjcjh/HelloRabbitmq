package com.haoge.rabbitmq.hello;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.106.196.212");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("520666");
        factory.setVirtualHost("/hello");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",false,false,false,null);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                String msg = new String(body);
                System.out.println(msg);
            }
        };

        channel.basicConsume("hello",true,consumer);
        connection.close();

    }

}
