package com.haoge.rabbitmq.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("47.106.196.212");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/hello");
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("520666");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",false,false,false,null);
        channel.basicPublish("","hello",null,"hello".getBytes());

        channel.close();
        connection.close();
    }
}
