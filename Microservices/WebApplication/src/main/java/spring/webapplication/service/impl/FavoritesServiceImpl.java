package spring.webapplication.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import spring.webapplication.model.Monument;
import spring.webapplication.model.User;
import spring.webapplication.model.Wish;
import spring.webapplication.service.FavoritesService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    private final RestTemplate restTemplate;
    public FavoritesServiceImpl(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    public Long addToFavoritesList(String username, String name) {
        String authUserEndpoint = "https://macscratchdeploy-production.up.railway.app/" + "/auth/authUser";
        System.out.println("ENDPOINT: " + authUserEndpoint);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", username);
        headers.set("Content-Type", "application/json");

        RequestCallback requestCallback = request -> request.getHeaders().addAll(headers);

        ResponseExtractor<ResponseEntity<Long>> responseExtractor = restTemplate.responseEntityExtractor(Long.class);

        ResponseEntity<Long> responseEntity = restTemplate.execute(authUserEndpoint, HttpMethod.GET, requestCallback, responseExtractor);

        //ResponseEntity<Long> responseEntity = restTemplate.getForEntity(authUserEndpoint, Long.class);
        System.out.println("RESPONSE: " + responseEntity);
        return responseEntity.getBody();
    }
    @Override
    public List<Monument> getFavoritesList(String username, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            Wish[] wishes1 = restTemplate.getForObject("https://macscratchdeploy-production.up.railway.app/wishlist/" + username, Wish[].class);
            List<Wish> wishes = Arrays.asList(wishes1);
            return wishes.stream().map(Wish::getMonument).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
