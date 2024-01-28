package spring.listsmicroservice.service;


import spring.listsmicroservice.model.Monument;

import java.util.List;

public interface WishService {
    void addToWishList(String username, String name);
    List<Monument> getWishList(String username);
}
