package spring.listsmicroservice.service;


import spring.listsmicroservice.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    void register(String username);
}
