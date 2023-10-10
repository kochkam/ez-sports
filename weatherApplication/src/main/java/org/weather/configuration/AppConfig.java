package org.weather.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Value("${weather.baseurl}")
    public String baseUrl;


    @Bean
    public WebClient defaultWebClient(){
        return WebClient.builder().baseUrl("https://api.weatherbit.io/v2.0/current").build();
    }
}
