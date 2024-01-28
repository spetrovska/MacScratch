package spring.listsmicroservice.service;


import spring.listsmicroservice.model.Monument;

import java.util.List;

public interface FavoritesService {
    void addToFavoritesList(String username, String name);
    List<Monument> getFavoritesList(String username);
}
