package spring.listsmicroservice.service;


import spring.listsmicroservice.model.Monument;

import java.util.List;

public interface VisitedService {
    void addToVisitedList(String username, String name);
    List<Monument> getVisitedList(String username);
}
