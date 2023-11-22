package com.example.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfig {
    /**
     * 实例化具体的缓存配置!
     *    设置缓存方式JSON
     *    设置缓存时间 单位秒
     * @param ttl
     * @return
     */

    private RedisCacheConfiguration redisCacheConfiguration(Long ttl){
        //设置jackson序列化工具
        GenericJackson2JsonRedisSerializer objectJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(ttl))//设置缓存时间
                .disableCachingNullValues()
                .serializeKeysWith(keyPair())
                .serializeValuesWith(valuePair());
    }

    //配置缓存管理器
    @Bean("cacheManagerHour")
    @Primary  //同类型,多个bean,默认生效! 默认缓存时间1小时!  可以选择!
    public CacheManager cacheManagerHour(RedisConnectionFactory factory){
        //缓存时间一小时
        RedisCacheConfiguration redisCacheConfiguration = redisCacheConfiguration(3600L);
        //构建缓存对象
        return RedisCacheManager.builder(factory)
                .cacheDefaults(redisCacheConfiguration)
                .transactionAware()
                .build();
    }

    //缓存一天的配置
    @Bean(name ="cacheManagerDay")
    public CacheManager cacheManagerDay(RedisConnectionFactory factory){
        //缓存时间为一天
        RedisCacheConfiguration redisCacheConfiguration = redisCacheConfiguration(24 * 3600L);
        return RedisCacheManager.builder(factory)
                .cacheDefaults(redisCacheConfiguration)
                .transactionAware()
                .build();
    }

    /**
     * 配置键序列化
     * @return String序列化
     */
    @Bean
    RedisSerializationContext.SerializationPair<String> keyPair(){
        return RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
    }

    /**
     * 配置值序列化
     * @return GenericJackson2JsonRedisSerializer序列化Object
     */
    @Bean
    RedisSerializationContext.SerializationPair<Object> valuePair(){
        return RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    }
}
