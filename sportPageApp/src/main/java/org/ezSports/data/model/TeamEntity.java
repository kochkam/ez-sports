package org.ezSports.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "teams")
@Table(schema = "public")
@Getter
@Setter
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int team_id;
    @Column(name = "team_name")
    String name;
    String logo;
    String league;
    boolean national_team;
    int country_id;
    LocalDateTime created_ts;
    LocalDateTime updated_ts;
}
