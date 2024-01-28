package spring.citiesmicroservice.service;

import spring.citiesmicroservice.model.City;

import java.util.List;

public interface CityService {
    City findByCityName(String name);
    List<City> findCities();
}
