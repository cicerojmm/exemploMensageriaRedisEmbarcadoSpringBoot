package com.example.redis.redisclient;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageListener implements MessageListener {

    public void onMessage(final Message message, final byte[] pattern) {
        System.out.println("Mensagem Recebida: " + new String(message.getBody()));
    }
}



