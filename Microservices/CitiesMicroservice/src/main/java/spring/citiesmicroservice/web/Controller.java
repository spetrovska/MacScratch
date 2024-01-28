package spring.citiesmicroservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.citiesmicroservice.model.City;
import spring.citiesmicroservice.model.Monument;
import spring.citiesmicroservice.service.CityService;
import spring.citiesmicroservice.service.MonumentService;

import java.util.List;

@RestController
@RequestMapping("/cities-monuments")
public class Controller {
    @Autowired
    private MonumentService monumentService;
    @Autowired
    private CityService cityService;

    @GetMapping("/GetMarkers")
    public List<Monument> getMarkers() {
        return monumentService.listAllMonuments();
    }

    @GetMapping("/GetCities")
    public List<City> getCities() {
        return cityService.findCities();
    }
}
