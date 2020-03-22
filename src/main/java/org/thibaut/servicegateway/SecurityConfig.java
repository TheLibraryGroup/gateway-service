package org.thibaut.servicegateway;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

//@Configuration
@EnableWebFluxSecurity
@AllArgsConstructor
//@CrossOrigin("*")
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
				.cors(  ).configurationSource(configurationSource()).and()
				.authorizeExchange()
				.anyExchange().permitAll()
//				.pathMatchers("/api/editor/**").authenticated()
//				.pathMatchers("/api/book/**").permitAll()
				.and()
				.oauth2ResourceServer()
				.jwt();
		return http.build();
	}

	private CorsConfigurationSource configurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("*");
		config.setAllowCredentials(true);
		config.addAllowedHeader("X-Requested-With");
		config.addAllowedHeader("Content-Type");
		config.addAllowedMethod( HttpMethod.POST);
		config.addAllowedMethod( HttpMethod.GET);
		source.registerCorsConfiguration("/logout", config);
		return source;
	}


}
