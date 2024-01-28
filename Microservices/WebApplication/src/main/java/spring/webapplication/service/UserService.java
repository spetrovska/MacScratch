package spring.webapplication.service;

import spring.webapplication.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    void register(String username, String password, String repeatPassword, String name, String surname);
    void setFeedbackAndSatisfied (String username, String feedback, Boolean satisfied);
}
