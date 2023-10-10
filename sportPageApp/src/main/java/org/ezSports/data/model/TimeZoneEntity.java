package org.ezSports.data.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(schema = "public")
@Entity(name = "timezone")
public class TimeZoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int zone_id;
    String timeZone;
    LocalDateTime created_ts;
    LocalDateTime updated_ts;


}
