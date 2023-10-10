package org.ezSports.repository;


import org.ezSports.data.model.CountryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<CountryEntity, Integer> {

    List<CountryEntity> findByCountryName(String country);

}
