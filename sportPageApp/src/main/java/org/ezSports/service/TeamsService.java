package org.ezSports.service;


import org.ezSports.client.SportClient;
import org.ezSports.data.Country;
import org.ezSports.data.Team;
import org.ezSports.data.model.CountryEntity;
import org.ezSports.data.model.TeamEntity;
import org.ezSports.mapper.TeamMapper;
import org.ezSports.repository.CountryRepository;
import org.ezSports.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamsService implements SportServiceInterface{


    @Autowired
    SportClient sportClient;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    TeamMapper teamMapper;



    public List<Team> getAllTeamsByLeague(String league, String sport){
        List<TeamEntity>  teamEntities = teamRepository.findByLeague(league);

        if (teamEntities.isEmpty()){
            List<Team> teams = sportClient.getTeams("1");

            List<TeamEntity> saveTeams = teamMapper.mapToEntities(teams);

            teamRepository.saveAll(saveTeams);

            return teams;
        }

        return teamMapper.mapTeams(teamEntities);
    };
/*
    public List<Country> getAllCountriesByName(String country){

        List<CountryEntity>  countryEntities = countryRepository.findByCountryName(country);

        if (countryEntities.isEmpty()){
            List<Team> teams = sportClient.getTeams("1");

            List<TeamEntity> saveTeams = teamMapper.mapToEntities(teams);

            teamRepository.saveAll(saveTeams);

            return teams;
        }

        return teamMapper.mapTeams(teamEntities);

    };*/

}
