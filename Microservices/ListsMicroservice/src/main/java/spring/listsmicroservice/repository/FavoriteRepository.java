package spring.listsmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.listsmicroservice.model.Favorite;
import spring.listsmicroservice.model.User;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    /*Returns all favorite monuments for the given user*/
    List<Favorite> findByUser(User user);
}
