package spring.webapplication.service;

import spring.webapplication.model.Monument;

import java.util.List;

public interface FavoritesService {
    void addToFavoritesList(String username, String name);
    List<Monument> getFavoritesList(String username);
}
