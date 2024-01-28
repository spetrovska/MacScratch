//package spring.webapplication.service.impl;
//
//import com.example.dians_proba.model.City;
//import com.example.dians_proba.repository.CityRepository;
//import com.example.dians_proba.service.CityService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CityServiceImpl implements CityService {
//    private final CityRepository cityRepository;
//
//    public CityServiceImpl(CityRepository cityRepository) {
//        this.cityRepository = cityRepository;
//    }
//
//    @Override
//    public City findByCityName(String name) {
//        return cityRepository.findCitiesByName(name);
//    }
//
//    @Override
//    public List<City> findCities() {
//        return cityRepository.findAll();
//    }
//}
