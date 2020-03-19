package org.thibaut.servicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class GatewayApplication {

//	@Bean
//	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//		return builder.routes()
//				       .route(route -> route
//						                   .path("/api/books/**")
//						                   .filters(f -> f.hystrix(config -> config.setName("d").setFallbackUri( "forward:/defaultBook"  )))
//						                   .uri("lb://thelibrary-ms-book")
//					                       .id( "ms-books" ))
//				.build();
//	}

	@Bean
	DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(
			ReactiveDiscoveryClient reactiveDiscoveryClient,
			DiscoveryLocatorProperties discoveryLocatorProperties ){
		return new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient, discoveryLocatorProperties);
	}

	public static void main( String[] args ) {
		SpringApplication.run( GatewayApplication.class, args );
	}

}
