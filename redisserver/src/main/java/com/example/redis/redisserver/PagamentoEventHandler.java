package com.example.redis.redisserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Pagamento.class)
public class PagamentoEventHandler {

    @Autowired
    private RedisPublisherService publisher;

    @HandleAfterCreate
    public void handler(Pagamento pagamento) {
        publisher.publicar(pagamento);
    }
}






