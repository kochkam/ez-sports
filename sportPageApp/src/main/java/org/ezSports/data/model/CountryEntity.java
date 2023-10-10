package org.ezSports.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "countries")
@Table(schema = "public")
@Getter
@Setter
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int country_id;
    @Column(name="country_name")
    String countryName;
    String country_code;
    String country_flag;
    LocalDateTime created_ts;
    LocalDateTime updated_ts;
}
