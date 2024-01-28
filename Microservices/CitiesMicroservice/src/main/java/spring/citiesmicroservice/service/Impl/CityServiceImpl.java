package spring.citiesmicroservice.service.Impl;

import org.springframework.stereotype.Service;
import spring.citiesmicroservice.model.City;
import spring.citiesmicroservice.repository.CityRepository;
import spring.citiesmicroservice.service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City findByCityName(String name) {
        return cityRepository.findCitiesByName(name);
    }

    @Override
    public List<City> findCities() {
        return cityRepository.findAll();
    }
}
