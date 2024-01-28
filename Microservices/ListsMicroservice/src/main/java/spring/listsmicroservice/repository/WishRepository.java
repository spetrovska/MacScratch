package spring.listsmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.listsmicroservice.model.User;
import spring.listsmicroservice.model.Wish;

import java.util.List;

public interface WishRepository extends JpaRepository<Wish, Long> {
    /*Returns all wishlist monuments for the given user*/
    List<Wish> findByUser(User user);
}
