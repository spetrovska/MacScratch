package spring.webapplication.service;

import jakarta.servlet.http.HttpServletRequest;
import spring.webapplication.model.Monument;

import java.util.List;

public interface VisitedService {
    Long addToVisitedList(String username, String name);
    List<Monument> getVisitedList(String username, HttpServletRequest request);
}
