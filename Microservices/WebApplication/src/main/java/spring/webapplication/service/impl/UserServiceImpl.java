package spring.webapplication.service.impl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.webapplication.model.User;
import spring.webapplication.model.Wish;
import spring.webapplication.model.exceptions.InvalidUsernameOrPasswordException;
import spring.webapplication.model.exceptions.PasswordsDoNotMatchException;
import spring.webapplication.model.exceptions.UsernameAlreadyExistsException;
import spring.webapplication.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final RestTemplate restTemplate;

    public UserServiceImpl(PasswordEncoder passwordEncoder, RestTemplate restTemplate) {
        this.passwordEncoder = passwordEncoder;
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<User> findByUsername(String username, HttpServletRequest request) {
        User user = restTemplate.getForObject("https://macscratchdeploy-production.up.railway.app/" + username, User.class);
        return Optional.ofNullable(user);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, HttpServletRequest request) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if (this.findByUsername(username, request).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(name, surname, username, passwordEncoder.encode(password));
        return user;
    }

    @Override
    public User setFeedbackAndSatisfied (String username, String feedback, Boolean satisfied, HttpServletRequest request) {
        User user = findByUsername(username, request).get();
        user.setFeedback(feedback);
        user.setSatisfied(satisfied);
        return user;
    }
}
