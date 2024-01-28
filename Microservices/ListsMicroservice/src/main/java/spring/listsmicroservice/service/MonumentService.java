package spring.listsmicroservice.service;


import spring.listsmicroservice.model.Monument;

import java.util.List;

public interface MonumentService {
    List<Monument> listAllMonuments();
    Monument findMonumentByName(String name);
    List<Monument> findAllMonumentsByName(String name);
    List<Monument> findMonumentByLatitudeAndLongitude(String lat, String lon);
}
