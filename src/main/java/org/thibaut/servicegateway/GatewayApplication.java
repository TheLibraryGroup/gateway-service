package org.thibaut.servicegateway;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.ObjectInputStream;

@SpringBootApplication
@CrossOrigin("*")
public class GatewayApplication {

//	private final JwtRequestFilter jwtRequestFilter;

//	@Autowired
//	private TokenRelayGatewayFilterFactory filterFactory;
//
//	@Bean
//	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//		return builder.routes()
//				       .route(route -> route
//						                   .path("/api/**")
////						                   .filters(f -> f.hystrix(config -> config.setName("d").setFallbackUri( "forward:/defaultBook"  )))
//						                   .filters(f -> f.filter( filterFactory.apply() ))
//						                   .uri("lb://thelibrary-ms-book")
//					                       .id( "ms-books" ))
//				.build();
//	}

//	@Bean
//	DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(
//			ReactiveDiscoveryClient reactiveDiscoveryClient,
//			DiscoveryLocatorProperties discoveryLocatorProperties ){
//		return new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient, discoveryLocatorProperties);
//	}

	public static void main( String[] args ) {
		SpringApplication.run( GatewayApplication.class, args );
	}

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain( ServerHttpSecurity http,
	                                                         ReactiveClientRegistrationRepository clientRegistrationRepository) {
		// Authenticate through configured OpenID Provider
//		http.oauth2Login();
//
//		// Also logout at the OpenID Connect provider
//		http.logout(logout -> logout.logoutSuccessHandler(
//				new OidcClientInitiatedServerLogoutSuccessHandler(clientRegistrationRepository)));

		// Require authentication for all requests
		http.cors().and().authorizeExchange().anyExchange().permitAll();
		// Allow showing /home within a frame
//		http.headers().frameOptions().mode( XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN);

		// Disable CSRF in the gateway to prevent conflicts with proxied service CSRF
//		http.csrf().disable();
//		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}
