package com.example.redis.redisserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	ChannelTopic topic() {
		return new ChannelTopic("pagamentos");
	}

	@Bean
	public RedisTemplate<String, Pagamento> redisTemplate() {
		final RedisTemplate<String, Pagamento> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Pagamento.class));
		return template;
	}

}


