package com.example.gateway;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
@Component("CustomRateLimiter")
public class CustomRateLimiter implements RateLimiter<Object> {

    private static final String REMAINING_TIME_IN_SECONDS_HEADER =
            "X-RateLimit-Remaining-Time-In-Seconds";
    private static final String TIME_IN_SECONDS_HEADER =
            "X-RateLimit-Time-In-Seconds";

    Map<String, String> customRatesForOrg = new HashMap<>()
    {
        {
            put("carbon.super", "3");
            put("tom", "4");
        }
    };

    private static final Log LOG = LogFactory.getLog(CustomRateLimiter.class);

    @Override
    public Mono<Response> isAllowed(String routeId, String id) {

        String ratePerOrg = customRatesForOrg.get(id);



        LOG.info("=====" + "id: " + id + " : " +
                "routeId: " + routeId) ;

        Response response = new Response(true, new HashMap<>());
        return Mono.just(response);
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
