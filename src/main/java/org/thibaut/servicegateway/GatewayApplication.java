package org.thibaut.servicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class GatewayApplication {

//	@Bean
//	RouteLocator routeLocator( RouteLocatorBuilder routeLocatorBuilder ){
//		return routeLocatorBuilder.routes()
//					.route( route->route.path( "/api/books/**" ).uri( "lb://thelibrary-microservice-catalog" ).id( "catalog-books" ) )
//				.build();
//	}

	@Bean
	DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator( ReactiveDiscoveryClient reactiveDiscoveryClient,
	                                                                             DiscoveryLocatorProperties discoveryLocatorProperties ){
		return new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient, discoveryLocatorProperties);
	}

	public static void main( String[] args ) {
		SpringApplication.run( GatewayApplication.class, args );
	}

}
