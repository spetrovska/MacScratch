package spring.webapplication.service;

import jakarta.servlet.http.HttpServletRequest;
import spring.webapplication.model.Monument;

import java.util.List;

public interface FavoritesService {
    Long addToFavoritesList(String username, String name);
    List<Monument> getFavoritesList(String username, HttpServletRequest request);
}
