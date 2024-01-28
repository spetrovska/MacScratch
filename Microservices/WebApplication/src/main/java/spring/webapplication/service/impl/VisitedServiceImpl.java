package spring.webapplication.service.impl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import spring.webapplication.model.User;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.webapplication.model.Monument;
import spring.webapplication.model.Visited;
import spring.webapplication.service.VisitedService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitedServiceImpl implements VisitedService {
    private final RestTemplate restTemplate;
    public VisitedServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Transactional
    @Override
    public Long addToVisitedList(String username, String name) {
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
    public List<Monument> getVisitedList(String username, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            Visited[] wishes1 = restTemplate.getForObject("https://macscratchdeploy-production.up.railway.app//visitedlist/" + username, Visited[].class);
            List<Visited> wishes = Arrays.asList(wishes1);
            return wishes.stream().map(Visited::getMonument).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
