package spring.webapplication.service;

import jakarta.servlet.http.HttpServletRequest;
import spring.webapplication.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> findByCityName(String name, HttpServletRequest request);
    Optional<City> findCities();
}
