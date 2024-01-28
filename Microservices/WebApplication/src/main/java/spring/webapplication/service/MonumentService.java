package spring.webapplication.service;

import jakarta.servlet.http.HttpServletRequest;
import spring.webapplication.model.Monument;

import java.util.List;

public interface MonumentService {
    List<Monument> listAllMonumentsSine(HttpServletRequest request);
}
