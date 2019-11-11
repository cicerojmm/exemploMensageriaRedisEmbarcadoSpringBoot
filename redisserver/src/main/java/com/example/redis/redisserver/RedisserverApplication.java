package com.example.redis.redisserver;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import redis.embedded.RedisServer;

@SpringBootApplication
public class RedisserverApplication {

	private RedisServer redisServer;

	@PostConstruct
	public void startRedis() throws IOException {
		redisServer = new RedisServer(6379);
		redisServer.start();
	}

	@PreDestroy
	public void stopRedis() {
		redisServer.stop();
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisserverApplication.class, args);
	}


}



