package org.weather.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {

    @Autowired
    private final WebClient defaultWebClient;

    public WeatherService(WebClient defaultWebClient){
        this.defaultWebClient = defaultWebClient;
    }
/*
    public ResponseEntity<String> determineRoute(String country, String city, String lat, String lon, String PostalCode){

        if(lat != null && lon != null){

        }


    }*/

    public ResponseEntity<String>  callWeatherAPI(String cityName) {

        cityName = cityName.replaceAll(" ", "%20");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.weatherbit.io/v2.0/current?city=" + cityName + "&key=7be0c95c388942c1bfce85e0def34bd8&units=I")).GET().build();
        return (defaultWebClient.get().retrieve().toEntity(String.class).block());

    }
}
