package spring.webapplication.service;

import spring.webapplication.model.City;

import java.util.List;

public interface CityService {
    City findByCityName(String name);
    List<City> findCities();
}
