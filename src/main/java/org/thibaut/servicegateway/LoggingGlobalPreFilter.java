//package org.thibaut.servicegateway;
//
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//@Component
//@Slf4j
//public class LoggingGlobalPreFilter implements GlobalFilter {
//
//	@Override
//	public Mono< Void > filter(
//			ServerWebExchange exchange,
//			GatewayFilterChain chain ) {
//		log.info( "Global Pre Filter executed" );
//		final List< String > jwtToken = exchange.getRequest( ).getHeaders( ).getValuesAsList( "Authorization" );
//		log.info( "TOKEN: " + jwtToken.toString( ) );
//		return chain.filter( exchange );
//	}
//}
