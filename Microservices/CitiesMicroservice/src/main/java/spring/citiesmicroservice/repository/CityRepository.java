package spring.citiesmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.citiesmicroservice.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
    City findCitiesByName(String name);
}
