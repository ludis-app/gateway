package com.ludis.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;


@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

	@RequestMapping("/fallback")
	public Mono<String> fallback() {
		return Mono.just("fallback");
	}

//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("path_route", r -> r.path("/users/all")
//						.uri("http://user-server:9000"))
//				.route("path_route", r -> r.path("/auth/hello")
//						.uri("http://auth-server:8004"))
//				.route("path_route", r -> r.path("/calories/all")
//						.uri("http://calories-server:9200"))
//				.route("path_route", r -> r.path("/steps/all")
//						.uri("http://steps-server:9100"))
//				.route("rewrite_route", r -> r.host("*.rewrite.org")
//						.filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
//						.uri("http://httpbin.org"))
//				.route(p -> p
//						.host("*.circuitbreaker.com")
//						.filters(f -> f.circuitBreaker(config -> config
//								.setName("mycircuit")
//								.setFallbackUri("forward:/fallback")))
//						.uri("http://httpbin.org:9000"))
//				.build();
//	}

	public static void main(String[] args) {


		SpringApplication.run(GatewayApplication.class, args);
	}

}
