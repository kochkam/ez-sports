package org.ezSports.controller;

import org.ezSports.data.Country;
import org.ezSports.data.Team;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface SportApiInterface {

    @GetMapping("/teams/{league}")
    public ResponseEntity<List<Team>> getByLeague(String league);

  /*  @GetMapping("teams/{country}")
    public ResponseEntity<List<Country>> getCountries(String country);*/
}
