package group.ship.blackshipstore.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Value(value = "${cache.expire}")
    private long cacheExpireAfterWrite;

    @Bean
    public CacheManager cacheManager(){
        return  new ConcurrentMapCacheManager(){
            @Override
            protected Cache createConcurrentMapCache(String name) {
                return new ConcurrentMapCache(
                name,
                        CacheBuilder.newBuilder()
                                .expireAfterWrite(cacheExpireAfterWrite, TimeUnit.MILLISECONDS)
                                .build().asMap(),
                        false);
            }
        };
    }
}
