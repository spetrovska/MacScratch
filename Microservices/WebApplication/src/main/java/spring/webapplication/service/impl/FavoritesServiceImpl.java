//package spring.webapplication.service.impl;
//
//import com.example.dians_proba.model.Favorite;
//import com.example.dians_proba.model.Monument;
//import com.example.dians_proba.model.User;
//import com.example.dians_proba.repository.FavoriteRepository;
//import com.example.dians_proba.repository.MonumentRepository;
//import com.example.dians_proba.repository.UserRepository;
//import com.example.dians_proba.service.FavoritesService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class FavoritesServiceImpl implements FavoritesService {
//    private final UserRepository userRepository;
//    private final MonumentRepository monumentRepository;
//    private final FavoriteRepository favoriteRepository;
//
//    public FavoritesServiceImpl(UserRepository userRepository, MonumentRepository monumentRepository, FavoriteRepository favoriteRepository) {
//        this.userRepository = userRepository;
//        this.monumentRepository = monumentRepository;
//        this.favoriteRepository = favoriteRepository;
//    }
//
//    @Override
//    public void addToFavoritesList(String username, String name) {
//        User user = userRepository.findByUsername(username).orElse(null);
//        Monument monument = monumentRepository.findByName(name);
//        Favorite favorite = new Favorite(user, monument);
//        //if(monument does not exist in wishRepo)
////        if(favoriteRepository.findByMonument(monument).isEmpty())
//        favoriteRepository.save(favorite);
//    }
//
//    @Override
//    public List<Monument> getFavoritesList(String username) {
//        User user = userRepository.findByUsername(username).orElse(null);
//        List<Favorite> favorites = favoriteRepository.findByUser(user);
//        return favorites.stream().map(Favorite::getMonument).collect(Collectors.toList());
//    }
//}
