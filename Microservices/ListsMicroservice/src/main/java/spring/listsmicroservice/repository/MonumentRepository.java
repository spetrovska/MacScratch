package spring.listsmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.listsmicroservice.model.Monument;

import java.util.List;

public interface MonumentRepository extends JpaRepository<Monument, Long> {
    Monument findByName(String name);
    List<Monument> findMonumentsByName(String name);

    /* Returns which monuments are near the user's approximate location */
    List <Monument> findByLatLikeAndLonLike(String lat, String lon) ;
}
