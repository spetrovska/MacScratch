package spring.listsmicroservice.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import spring.listsmicroservice.model.Monument;
import spring.listsmicroservice.model.User;
import spring.listsmicroservice.model.Visited;
import spring.listsmicroservice.repository.MonumentRepository;
import spring.listsmicroservice.repository.UserRepository;
import spring.listsmicroservice.repository.VisitedRepository;
import spring.listsmicroservice.service.VisitedService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitedServiceImpl implements VisitedService {
    private final UserRepository userRepository;
    private final MonumentRepository monumentRepository;
    private final VisitedRepository visitedRepository;

    public VisitedServiceImpl(UserRepository userRepository, MonumentRepository monumentRepository, VisitedRepository visitedRepository) {
        this.userRepository = userRepository;
        this.monumentRepository = monumentRepository;
        this.visitedRepository = visitedRepository;
    }

    @Transactional
    @Override
    public void addToVisitedList(String username, String name) {
        User user = userRepository.findByUsername(username).orElse(null);
        Monument monument = monumentRepository.findByName(name);
        Visited visited = new Visited(user, monument);
        //if(monument does not exist in visitedRepository)
//        if(visitedRepository.findByMonument(monument).isEmpty())
        visitedRepository.save(visited);
    }

    @Override
    public List<Monument> getVisitedList(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        List<Visited> visiteds = visitedRepository.findByUser(user);
        return visiteds.stream().map(Visited::getMonument).collect(Collectors.toList());
    }
}
