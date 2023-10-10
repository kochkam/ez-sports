package org.ezSports.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {


    @Bean
    public WebClient defaultWebClient(){
        return WebClient.builder().baseUrl("https://v1.baseball.api-sports.io/teams?league=1&season=2023").defaultHeaders(httpHeaders -> {
            httpHeaders.set("x-rapidapi-host","v1.baseball.api-sports.io");
            httpHeaders.set("x-rapidapi-key","b688d5bbc14da041cbf4afe25210f7f2");
        }).build();
    }

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Your API Title")
                        .description("Your API Description")
                        .version("1.0"));
    }
}
