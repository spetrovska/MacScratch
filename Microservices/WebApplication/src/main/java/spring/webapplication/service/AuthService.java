package spring.webapplication.service;


import spring.webapplication.model.User;

public interface AuthService {
    User login(String username, String password);
}
