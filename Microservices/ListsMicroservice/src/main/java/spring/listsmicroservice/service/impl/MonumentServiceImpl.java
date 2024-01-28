package spring.listsmicroservice.service.impl;

import org.springframework.stereotype.Service;
import spring.listsmicroservice.model.Monument;
import spring.listsmicroservice.repository.MonumentRepository;
import spring.listsmicroservice.service.MonumentService;

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

    public List<Monument> findMonumentByLatitudeAndLongitude(String lat, String lon) {
        return monumentRepository.findByLatLikeAndLonLike(lat, lon);
    };
}
