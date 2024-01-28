package spring.webapplication.service.impl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.webapplication.model.City;
import spring.webapplication.model.User;
import spring.webapplication.model.exceptions.InvalidArgumentsException;
import spring.webapplication.model.exceptions.InvalidUserCredentialsException;
import spring.webapplication.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final RestTemplate restTemplate;

    public AuthServiceImpl(PasswordEncoder passwordEncoder, RestTemplate restTemplate) {
        this.passwordEncoder = passwordEncoder;
        this.restTemplate = restTemplate;
    }

    @Override
    public User login(String username, String password, HttpServletRequest request) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        User[] users = restTemplate.getForObject("https://macscratchdeploy-production.up.railway.app/"+username,User[].class);
        return userRepository.findByUsernameAndPassword(username, passwordEncoder.encode(password)
        ).orElseThrow(InvalidUserCredentialsException::new);
    }

}
