package com.cue.personajesservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Bean
    public RestClient clasesRestClient(@Value("${clases.service.url}") String clasesServiceUrl) {
        return RestClient.builder()
                .baseUrl(clasesServiceUrl)
                .build();
    }
}
