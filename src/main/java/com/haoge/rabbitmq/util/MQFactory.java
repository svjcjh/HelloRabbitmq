package com.haoge.rabbitmq.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MQFactory {

    public static Connection getConnection() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("47.106.196.212");
            factory.setPort(5672);
            factory.setUsername("root");
            factory.setPassword("520666");
            factory.setVirtualHost("/hello");
            return factory.newConnection();
        }
        catch (TimeoutException timeoutException) {
            timeoutException.printStackTrace();
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

    public static void close(Channel channel,Connection connection) throws IOException, TimeoutException {
        if (channel != null) {
            channel.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

}
