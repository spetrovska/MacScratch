package spring.listsmicroservice.service.impl;

import org.springframework.stereotype.Service;
import spring.listsmicroservice.model.User;
import spring.listsmicroservice.repository.UserRepository;
import spring.listsmicroservice.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void register(String username) {

        User user = new User(username);
        userRepository.save(user);
    }

}
