package com.stackroute.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator gatewayRouteLocater(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->r.path("/api/v1/auth/**")
						.uri("lb://LOGIN-SERVICE"))
				.route(r->r.path("/api/events/**")
						.uri("lb://EVENT-SERVICE"))
				.route(r->r.path("/api/participated-users/**")
						.uri("lb://EVENT-SERVICE"))
				.route(r->r.path("/user/**")
						.uri("lb://CHAT-SERVICE"))
				.route(r->r.path("/chats/**")
						.uri("lb://CHAT-SERVICE"))
				.route(r->r.path("/api/gym/**")
						.uri("lb://ADMIN-SERVICE"))
				.route(r->r.path("/api/gym/equipments/**")
						.uri("lb://ADMIN-SERVICE"))
				.route(r->r.path("/api/gym/subscriptions/**")
						.uri("lb://ADMIN-SERVICE"))
				.route(r->r.path("/api/gym/trainers/**")
						.uri("lb://ADMIN-SERVICE"))
				.route(r->r.path("/api/feedback/**")
						.uri("lb://FEEDBACK-SERVICE"))
				.route(r->r.path("/api/notification/**")
						.uri("lb://NOTIFICATION-SERVICE"))
				.route(r->r.path("/sms/**")
						.uri("lb://NOTIFICATION-SERVICE"))
				.route(r->r.path("/payments/**")
						.uri("lb://PAYMENT-SERVICE"))
				.route(r->r.path("/auth/**")
						.uri("lb://REGISTRATION-SERVICE"))
				.route(r->r.path("/**")
						.uri("lb://PRODUCT-WEBAPP-SERVICE"))



				.build();
	}



}
