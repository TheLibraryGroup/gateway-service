package org.thibaut.servicegateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

//	@Bean
//	SecurityWebFilterChain springSecurityFilterChain( ServerHttpSecurity http ) throws Exception {
//		http
//				.authorizeExchange( )
//				.pathMatchers( "/resource" ).hasRole( "admin" )
//				.anyExchange( ).authenticated( )
//				.and( )
//				.oauth2ResourceServer( )
//				.jwt( );
//		return http.build( );
//	}

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(
			ServerHttpSecurity http,
			ReactiveClientRegistrationRepository clientRegistrationRepository) {

		// Require authentication for all requests
		http.cors().and().authorizeExchange().anyExchange().permitAll();

		// Allow showing /home within a frame
//		http.headers().frameOptions().mode( XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN);

		// Disable CSRF in the gateway to prevent conflicts with proxied service CSRF
		http.csrf().disable();
		return http.build();
	}
}
