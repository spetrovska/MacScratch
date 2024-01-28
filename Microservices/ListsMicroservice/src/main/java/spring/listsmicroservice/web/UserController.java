package spring.listsmicroservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.listsmicroservice.service.UserService;

@Controller
@RequestMapping("/add-user/lists")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{username}")
    public void addUser(@PathVariable String username){
        userService.register(username);
    }
}
