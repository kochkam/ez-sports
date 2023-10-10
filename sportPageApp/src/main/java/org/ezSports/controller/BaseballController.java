package org.ezSports.controller;



import org.ezSports.data.Country;
import org.ezSports.data.Team;
import org.ezSports.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/baseball")
public class BaseballController implements SportApiInterface {

    @Autowired
    TeamsService teamsService;

    @Override
    public ResponseEntity<List<Team>> getByLeague(String league){
    return  new ResponseEntity<List<Team>>(teamsService.getAllTeamsByLeague(league, "baseball"), HttpStatusCode.valueOf(200));
    }
/*
    @Override
    public ResponseEntity<List<Country>> getCountries(String country) {
        return new ResponseEntity<List<Country>>(teamsService.getAllCountriesByName(country), HttpStatusCode.valueOf(200));
    }*/
}
