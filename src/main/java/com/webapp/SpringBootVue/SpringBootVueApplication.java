package com.webapp.SpringBootVue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableScheduling
public class SpringBootVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootVueApplication.class, args);
    }

    @Bean
    public WebClient.Builder webClientBuilder() {
        System.out.println("STARTING...");
        return WebClient.builder();
    }
}
