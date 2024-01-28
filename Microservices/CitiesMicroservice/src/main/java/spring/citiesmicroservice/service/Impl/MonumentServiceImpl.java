package spring.citiesmicroservice.service.Impl;

import org.springframework.stereotype.Service;
import spring.citiesmicroservice.model.Monument;
import spring.citiesmicroservice.repository.MonumentRepository;
import spring.citiesmicroservice.service.MonumentService;

import java.util.List;

@Service
public class MonumentServiceImpl implements MonumentService {
    public final MonumentRepository monumentRepository;

    public MonumentServiceImpl(MonumentRepository monumentRepository) {
        this.monumentRepository = monumentRepository;
    }

    @Override
    public List<Monument> listAllMonuments() {
        return monumentRepository.findAll();
    }

    @Override
    public Monument findMonumentByName(String name) {
        return monumentRepository.findByName(name);
    }

    @Override
    public List<Monument> findAllMonumentsByName(String name) {
        return monumentRepository.findMonumentsByName(name);
    }

    /* For finding which monuments are in the user's approximate live location */
    public List<Monument> findMonumentByLatitudeAndLongitude(String lat, String lon) {
        return monumentRepository.findByLatLikeAndLonLike(lat, lon);
    }

}