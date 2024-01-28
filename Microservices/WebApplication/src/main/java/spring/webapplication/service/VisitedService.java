package spring.webapplication.service;

import spring.webapplication.model.Monument;

import java.util.List;

public interface VisitedService {
    void addToVisitedList(String username, String name);
    List<Monument> getVisitedList(String username);
}
