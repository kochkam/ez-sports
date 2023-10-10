package org.ezSports.repository;

import org.ezSports.data.model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<TeamEntity,Integer> {

    List<TeamEntity> findByName(String name);
    List<TeamEntity> findByLeague(String league);
}
