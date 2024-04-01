package com.example.gateway;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.ratelimit.AbstractRateLimiter;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.support.ConfigurationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;


@Service
@Primary
@Component
public class CustomRateLimiter implements RateLimiter<Object> {

    @Override
    public Mono<Response> isAllowed(String routeId, String id) {
        return null;
    }

    @Override
    public Map<String, Object> getConfig() {
        return null;
    }

    @Override
    public Class<Object> getConfigClass() {
        return null;
    }

    @Override
    public Object newConfig() {
        return null;
    }
}
