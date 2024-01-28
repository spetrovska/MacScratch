//package spring.webapplication.service.impl;
//
//import com.example.dians_proba.model.Monument;
//import com.example.dians_proba.repository.MonumentRepository;
//import com.example.dians_proba.service.MonumentService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MonumentServiceImpl implements MonumentService {
//    public final MonumentRepository monumentRepository;
//
//    public MonumentServiceImpl(MonumentRepository monumentRepository) {
//        this.monumentRepository = monumentRepository;
//    }
//    @Override
//    public List<Monument> listAllMonumentsSine() {
//        return monumentRepository.findAll();
//    }
//
//    @Override
//    public Monument findMonumentByName(String name) {
//        return monumentRepository.findByName(name);
//    }
//    @Override
//    public List<Monument> findAllMonumentsByName(String name) {
//        return monumentRepository.findMonumentsByName(name);
//    }
//
//    public List<Monument> findMonumentByLatitudeAndLongitude(String lat, String lon) {
//        return monumentRepository.findByLatLikeAndLonLike(lat, lon);
//    };
//}
