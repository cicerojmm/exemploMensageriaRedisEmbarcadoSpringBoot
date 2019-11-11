package com.example.redis.redisserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class RedisPublisherService {

    @Autowired
    private RedisTemplate<String, Pagamento> redisTemplate;

    @Autowired
    private ChannelTopic topico;

    public void publicar(Pagamento mensagem) {
        redisTemplate.convertAndSend(topico.getTopic(), mensagem);
    }
}


