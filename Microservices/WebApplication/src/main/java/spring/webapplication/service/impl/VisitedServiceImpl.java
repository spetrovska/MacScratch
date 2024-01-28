//package spring.webapplication.service.impl;
//
//import com.example.dians_proba.model.*;
//import com.example.dians_proba.repository.MonumentRepository;
//import com.example.dians_proba.repository.UserRepository;
//import com.example.dians_proba.repository.VisitedRepository;
//import com.example.dians_proba.service.VisitedService;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class VisitedServiceImpl implements VisitedService {
//    private final UserRepository userRepository;
//    private final MonumentRepository monumentRepository;
//    private final VisitedRepository visitedRepository;
//
//    public VisitedServiceImpl(UserRepository userRepository, MonumentRepository monumentRepository, VisitedRepository visitedRepository) {
//        this.userRepository = userRepository;
//        this.monumentRepository = monumentRepository;
//        this.visitedRepository = visitedRepository;
//    }
//
//    @Transactional
//    @Override
//    public void addToVisitedList(String username, String name) {
//        User user = userRepository.findByUsername(username).orElse(null);
//        Monument monument = monumentRepository.findByName(name);
//        Visited visited = new Visited(user, monument);
//        //if(monument does not exist in visitedRepository)
////        if(visitedRepository.findByMonument(monument).isEmpty())
//        visitedRepository.save(visited);
//    }
//
//    @Override
//    public List<Monument> getVisitedList(String username) {
//        User user = userRepository.findByUsername(username).orElse(null);
//        List<Visited> visiteds = visitedRepository.findByUser(user);
//        return visiteds.stream().map(Visited::getMonument).collect(Collectors.toList());
//    }
//}
