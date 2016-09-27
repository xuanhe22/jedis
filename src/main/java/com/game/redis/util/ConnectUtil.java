package com.game.redis.util;

import com.game.redis.obj.BasePo;
import redis.clients.jedis.ShardedJedis;

public class ConnectUtil {

	public static ShardedJedis getConnect(){
		ShardedJedis pool = null;
		try {
			pool = GlobalUtil.shardedJedisPool.getResource();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pool;
	}
	
	public static void closeConnect(ShardedJedis shardedJedis){
		if(shardedJedis!=null){
			try {
				shardedJedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static <T extends BasePo> T getData(Class<T> clazz, long id){
		BasePo basePo = null;
		try {
			ShardedJedis shardedJedis = getConnect();
			String objKey = ((BasePo)GlobalUtil.applicationContext.getBean(clazz)).getKey()+id;
			basePo = (BasePo)SerializingUtil.deserialize(getConnect().get(objKey.getBytes()));
			closeConnect(shardedJedis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T)basePo;
	}
	
	public static void setData(BasePo basePo){
		try {
			ShardedJedis shardedJedis = getConnect();
			String objKey = basePo.getObjectKey();
			shardedJedis.set(objKey.getBytes(), SerializingUtil.serialize(basePo));
			closeConnect(shardedJedis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
