
package com.example.gateway;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import static io.netty.handler.logging.LogLevel.INFO;

@SpringBootApplication
@RestController
public class GatewayApplication {

	Log log = LogFactory.getLog(getClass());

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

//	@Bean("customKeyResolver")
//	public KeyResolver customKeyResolver(){
//		//String ipAddress = Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
//		//return Mono.just(ipAddress);
//		log.info("----");
//		System.out.println("----");
//		return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
//	}
}
