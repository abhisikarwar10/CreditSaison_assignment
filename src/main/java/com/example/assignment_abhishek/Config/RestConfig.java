package com.example.assignment_abhishek.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
    //RestTemplate can be configured here as it suits to our needs
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
