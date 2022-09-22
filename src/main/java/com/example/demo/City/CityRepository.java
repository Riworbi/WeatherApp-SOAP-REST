package com.example.demo.City;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {

	List<City> findAll();

	City findByName(String name);
}
