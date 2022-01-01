package com.haoge.rabbitmq.work;

import com.haoge.rabbitmq.util.MQFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = MQFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work",false,false,false,null);

        for (int i = 0; i < 20; i++) {
            channel.basicPublish("","work",null,(i + ": Hello Rabbitmq").getBytes());
        }
        MQFactory.close(channel,connection);
    }
}
