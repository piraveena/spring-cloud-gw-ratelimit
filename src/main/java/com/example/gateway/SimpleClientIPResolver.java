package com.example.gateway;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component("SimpleClientIPResolver")
public class SimpleClientIPResolver implements KeyResolver {

    Log log = LogFactory.getLog(getClass());

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        log.info("----");
        System.out.println("----");
        String path = exchange.getRequest().getPath().toString();
        System.out.println(path);
        String org = "";
        if (path.contains("/t/carbon.super")){
            org = "carbon.super";
        }
        String ip =  exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
        System.out.println(ip);
        return Mono.just(path);
    }
}