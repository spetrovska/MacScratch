package spring.webapplication.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.webapplication.model.City;
import spring.webapplication.service.CityService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private final RestTemplate restTemplate;

    public CityServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<City> findByCityName(String name, HttpServletRequest request) {
        City[] cities = restTemplate.getForObject("https://macscratchdeploy-production.up.railway.app/"+name,City[].class);
        List<City> cities1 = Arrays.asList(cities);
        if(cities1.size()>1)
        {
            return cities1;
        }
        return cities1;
    }

    @Override
    public Optional<City> findCities() {
        City[] cities = restTemplate.getForObject("https://macscratchdeploy-production.up.railway.app/", City[].class);
        List<City> cities1 = Arrays.asList(cities);
        if(cities1.size()==1)
            return Optional.of(cities1.get(0));
        else
            return Optional.empty();
    }
}
