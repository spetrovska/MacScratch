package spring.webapplication.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.webapplication.model.Monument;
import spring.webapplication.model.User;
import spring.webapplication.model.Wish;
import spring.webapplication.service.WishService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishServiceImpl implements WishService {
    private final RestTemplate restTemplate;

    public WishServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void addToWishList(String username, String name) {

//        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:9000/wishlist/"+name, null, String.class);

    }

    @Override
    public List<Monument> getWishList(String username, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            Wish[] wishes1 = restTemplate.getForObject("http://localhost:9000/wishlist/" + username, Wish[].class);
            List<Wish> wishes = Arrays.asList(wishes1);
            return wishes.stream().map(Wish::getMonument).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
