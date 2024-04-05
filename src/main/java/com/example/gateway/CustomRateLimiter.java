package com.example.gateway;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
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

        // Get the rate limit of the org+api
        String ratePerOrg = customRatesForOrg.get(id);
        LOG.info("=====" + "id: " + id + " : " +
                "routeId: " + routeId) ;
        // Initialise some cache logic and fill it with the bucket size.

        // When an API request comes, decrease the bucket size. Again, clear the cache and refill it after 1s.

        // If the cache exists, return true.
        Response response = new Response(true, new HashMap<>());

        // If cache is not there, return false. GW will send 429 if `allowed`=false;
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
