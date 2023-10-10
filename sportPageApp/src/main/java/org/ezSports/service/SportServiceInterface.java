package org.ezSports.service;


import org.ezSports.data.Country;
import org.ezSports.data.Team;

import java.util.List;

public interface SportServiceInterface {

    public List<Team> getAllTeamsByLeague(String league, String sport);

    //public List<Country> getAllCountriesByName(String sport);
}
