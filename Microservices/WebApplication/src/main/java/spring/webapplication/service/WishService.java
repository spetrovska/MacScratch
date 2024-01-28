package spring.webapplication.service;

import jakarta.servlet.http.HttpServletRequest;
import spring.webapplication.model.Monument;

import java.util.List;

public interface WishService {
    Long addToWishList(String username, String name);
    List<Monument> getWishList(String username, HttpServletRequest request);
}
