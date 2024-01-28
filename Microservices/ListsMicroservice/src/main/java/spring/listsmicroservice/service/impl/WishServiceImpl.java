package spring.listsmicroservice.service.impl;

import org.springframework.stereotype.Service;
import spring.listsmicroservice.model.Monument;
import spring.listsmicroservice.model.User;
import spring.listsmicroservice.model.Wish;
import spring.listsmicroservice.repository.MonumentRepository;
import spring.listsmicroservice.repository.UserRepository;
import spring.listsmicroservice.repository.WishRepository;
import spring.listsmicroservice.service.WishService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishServiceImpl implements WishService {
    private final UserRepository userRepository;
    private final MonumentRepository monumentRepository;
    private final WishRepository wishRepository;

    public WishServiceImpl(UserRepository userRepository, MonumentRepository monumentRepository, WishRepository wishRepository) {
        this.userRepository = userRepository;
        this.monumentRepository = monumentRepository;
        this.wishRepository = wishRepository;
    }

    @Override
    public void addToWishList(String username, String name) {
        User user = userRepository.findByUsername(username).orElse(null);
        Monument monument = monumentRepository.findByName(name);
        Wish wish = new Wish(user, monument);
        //if(monument does not exist in wishRepo)
//        if(wishRepository.findByMonument(monument).isEmpty())
        wishRepository.save(wish);
    }

    @Override
    public List<Monument> getWishList(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        List<Wish> wishes = wishRepository.findByUser(user);
        return wishes.stream().map(Wish::getMonument).collect(Collectors.toList());
    }
}
