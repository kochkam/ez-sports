package org.weather.controllers;

import org.weather.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class WeatherController {

    @Autowired
    private WeatherService weatherService;


    @GetMapping("/cityAndCountryWeather")
    public ResponseEntity<?> getCityWeather(@RequestParam(name = "City", required = false) String city,
                                            @RequestParam(name = "Country", required = false) String country,
                                            @RequestParam(name = "Postal Code", required = false) String postalCode,
                                            @RequestParam(name = "Lat", required = false) String lat,
                                            @RequestParam(name = "Long", required = false) String lang) {
        return weatherService.callWeatherAPI(city);
    }

    /*
    @GetMapping("/postalCodeAndCountry")
    public String getPostalCodeWeather(@RequestParam Integer postalCode, @RequestParam String country){

    }
*/
}
