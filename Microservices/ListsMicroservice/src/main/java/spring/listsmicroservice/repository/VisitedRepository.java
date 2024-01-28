package spring.listsmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.listsmicroservice.model.User;
import spring.listsmicroservice.model.Visited;

import java.util.List;

public interface VisitedRepository extends JpaRepository<Visited,Long> {
    /*Returns all visited monuments for the given user*/
    List<Visited> findByUser(User user);
}
