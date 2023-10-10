package org.ezSports.client;



import org.ezSports.data.Country;
import org.ezSports.data.Team;

import java.util.List;

public interface SportApiClientInterface {

    public List<Team> getTeams(String leagueId);

    public List<Country> getCountries();
}
