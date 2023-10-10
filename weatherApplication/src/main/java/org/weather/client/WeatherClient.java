package org.weather.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class WeatherClient {
    @Value("${weather.baseurl}")
    public String baseUrl;

    @Autowired
    WebClient defaultWebClient;


    public ResponseEntity<String> callWeatherAPI(String cityName) {

        cityName = cityName.replaceAll(" ", "%20");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.weatherbit.io/v2.0/current?city=" + cityName + "&key=7be0c95c388942c1bfce85e0def34bd8&units=I")).GET().build();
        return (defaultWebClient.get().retrieve().toEntity(String.class).block());

    }

}
