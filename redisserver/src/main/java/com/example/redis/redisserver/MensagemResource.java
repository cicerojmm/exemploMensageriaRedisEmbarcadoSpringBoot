package com.example.redis.redisserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pagamentos")
public class MensagemResource {

    @Autowired
    RedisPublisherService service;

    @PostMapping
    public void salvar() {
        Pagamento pagamento = new Pagamento();
        pagamento.setCodigo("1234");
        pagamento.setValor("99.99");
        service.publicar(pagamento);
    }
}




