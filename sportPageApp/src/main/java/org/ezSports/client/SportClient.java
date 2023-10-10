package org.ezSports.client;


import org.ezSports.data.Country;
import org.ezSports.data.CountryResponse;
import org.ezSports.data.Team;
import org.ezSports.data.TeamResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class SportClient implements SportApiClientInterface{

    @Autowired
    private WebClient defaultWebClient;

    public List<Team> getTeams(String leagueId){
        TeamResponse teamResponse;


        try {
            teamResponse = defaultWebClient.get().uri( uriBuilder -> uriBuilder
                                    .path("https://v1.baseball.api-sports.io/teams?league=1&season=2023")
                                    .build())
                    .retrieve().bodyToMono(TeamResponse.class).block();
            return teamResponse != null ? teamResponse.getResponse() : null;

        } catch (Exception e){
            System.out.println(e);
        }

        return null;
    };

    public List<Country> getCountries(){
        CountryResponse countryResponse;

        try {
            countryResponse = defaultWebClient.get().uri(uriBuilder -> uriBuilder
                            .path("https://v1.baseball.api-sports.io/counties").build())
                    .retrieve().bodyToMono(CountryResponse.class).block();
            return countryResponse != null ? countryResponse.getResponse() : null;

        } catch (Exception e){
            System.out.println(e);
        }

        return null;
    };


}
