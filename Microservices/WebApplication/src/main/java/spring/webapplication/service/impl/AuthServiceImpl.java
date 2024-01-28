//package spring.webapplication.service.impl;
//
//import com.example.dians_proba.model.User;
//import com.example.dians_proba.model.exceptions.InvalidArgumentsException;
//import com.example.dians_proba.model.exceptions.InvalidUserCredentialsException;
//import com.example.dians_proba.repository.UserRepository;
//import com.example.dians_proba.service.AuthService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthServiceImpl implements AuthService {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public User login(String username, String password) {
//        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
//            throw new InvalidArgumentsException();
//        }
//        return userRepository.findByUsernameAndPassword(username, passwordEncoder.encode(password)
//        ).orElseThrow(InvalidUserCredentialsException::new);
//    }
//
//}
