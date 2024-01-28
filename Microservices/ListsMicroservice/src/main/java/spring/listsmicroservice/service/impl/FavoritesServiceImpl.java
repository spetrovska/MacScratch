package spring.listsmicroservice.service.impl;

import org.springframework.stereotype.Service;
import spring.listsmicroservice.model.Favorite;
import spring.listsmicroservice.model.Monument;
import spring.listsmicroservice.model.User;
import spring.listsmicroservice.repository.FavoriteRepository;
import spring.listsmicroservice.repository.MonumentRepository;
import spring.listsmicroservice.repository.UserRepository;
import spring.listsmicroservice.service.FavoritesService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    private final UserRepository userRepository;
    private final MonumentRepository monumentRepository;
    private final FavoriteRepository favoriteRepository;

    public FavoritesServiceImpl(UserRepository userRepository, MonumentRepository monumentRepository, FavoriteRepository favoriteRepository) {
        this.userRepository = userRepository;
        this.monumentRepository = monumentRepository;
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public void addToFavoritesList(String username, String name) {
        User user = userRepository.findByUsername(username).orElse(null);
        Monument monument = monumentRepository.findByName(name);
        Favorite favorite = new Favorite(user, monument);
        //if(monument does not exist in wishRepo)
//        if(favoriteRepository.findByMonument(monument).isEmpty())
        favoriteRepository.save(favorite);
    }

    @Override
    public List<Monument> getFavoritesList(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        List<Favorite> favorites = favoriteRepository.findByUser(user);
        return favorites.stream().map(Favorite::getMonument).collect(Collectors.toList());
    }
}
