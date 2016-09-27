package com.game.redis.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.ShardedJedisPool;

public class GlobalUtil {

	public static ApplicationContext applicationContext;
	public static ShardedJedisPool shardedJedisPool;
	
	public static void init(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		shardedJedisPool = (ShardedJedisPool) applicationContext.getBean("shardedJedisPool");
	}
}
