package org.thibaut.servicegateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;

//@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

//	@Bean
//	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http,
//	                                                        ReactiveClientRegistrationRepository clientRegistrationRepository) {
//		// Authenticate through configured OpenID Provider
////		http.oauth2Login();
////		// Also logout at the OpenID Connect provider
////		http.logout(logout -> logout.logoutSuccessHandler(new OidcClientInitiatedServerLogoutSuccessHandler(
////				clientRegistrationRepository)));
//		// Require authentication for all requests
////		http.authorizeExchange().anyExchange().authenticated();
//		// Allow showing /home within a frame
//		http.authorizeExchange().pathMatchers( "http://localhost:8081/THELIBRARY-MS-BOOK/api/book/**" ).permitAll();
//		http.headers().frameOptions().mode( XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN);
//		// Disable CSRF in the gateway to prevent conflicts with proxied service CSRF
//		http.csrf().disable();
//		return http.build();
//	}

	@Bean
	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
		http
				.authorizeExchange()
				.anyExchange().permitAll()
//				.pathMatchers("/api/editor/**").authenticated()
//				.pathMatchers("/api/book/**").permitAll()
				.and()
				.oauth2ResourceServer()
				.jwt();
		return http.build();
	}


}
