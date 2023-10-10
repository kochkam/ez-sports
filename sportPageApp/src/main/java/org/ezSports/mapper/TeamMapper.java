package org.ezSports.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.ezSports.data.Team;
import org.ezSports.data.model.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TeamMapper {

    @Autowired
    ObjectMapper objectMapper;
    public List<Team> mapTeams(List<TeamEntity> teamEntities){
        List<Team> teams = new ArrayList<>();
        for (TeamEntity team: teamEntities) {
            Team mappedTeam = objectMapper.convertValue(team,Team.class);
            teams.add(mappedTeam);
        }
        return teams;
    }

    public List<TeamEntity> mapToEntities(List<Team> teams){
        List<TeamEntity> teamEntities = new ArrayList<>();
        for (Team team: teams) {
            TeamEntity mappedTeam = objectMapper.convertValue(team,TeamEntity.class);
            mappedTeam.setUpdated_ts(LocalDateTime.now());
            mappedTeam.setLeague("MLB");
            mappedTeam.setCreated_ts(LocalDateTime.now());
            teamEntities.add(mappedTeam);
        }
        return teamEntities;
    }
}
