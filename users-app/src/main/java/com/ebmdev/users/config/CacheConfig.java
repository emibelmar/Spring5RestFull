package com.ebmdev.users.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

	/**
	 * Comentamos esta clase para no necesitar levantar redis constantemente, si
	 * quieramos hacer uso de ella solo tendríamos que descomentarla y levantar
	 * redis antes de levantar nuestra aplicación
	 */

//	@Bean
//	public CacheManager getCache(RedissonClient redissonClient) {
//		Map<String, CacheConfig> config = new HashMap<>();
//		config.put("users", new CacheConfig());
//		return new RedissonSpringCacheManager(redissonClient);
//	}
//
//	@Bean(destroyMethod = "shutdown")
//	public RedissonClient redisson() {
//		Config config = new Config();
//		config.useSingleServer().setAddress("redis://127.0.0.1:6379");
//		return Redisson.create(config);
//	}
}
