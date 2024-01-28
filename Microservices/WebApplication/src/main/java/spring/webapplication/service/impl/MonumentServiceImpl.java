package spring.webapplication.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.webapplication.model.Monument;
import spring.webapplication.model.Wish;
import spring.webapplication.service.MonumentService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonumentServiceImpl implements MonumentService {
    private final RestTemplate restTemplate;

    public MonumentServiceImpl( RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Monument> listAllMonumentsSine(HttpServletRequest request) {
        Wish[] wishes1 = restTemplate.getForObject("https://macscratchdeploy-production.up.railway.app//scratch/all", Wish[].class);
        List<Wish> wishes = Arrays.asList(wishes1);
        return wishes.stream().map(Wish::getMonument).collect(Collectors.toList());
    }

}
