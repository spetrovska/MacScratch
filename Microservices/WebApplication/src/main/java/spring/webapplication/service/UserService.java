package spring.webapplication.service;

import jakarta.servlet.http.HttpServletRequest;
import spring.webapplication.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username, HttpServletRequest request);
    User register(String username, String password, String repeatPassword, String name, String surname, HttpServletRequest request);
    User setFeedbackAndSatisfied (String username, String feedback, Boolean satisfied, HttpServletRequest request);
}
