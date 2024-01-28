package spring.listsmicroservice.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.listsmicroservice.model.Monument;
import spring.listsmicroservice.model.User;
import spring.listsmicroservice.model.exceptions.InvalidUsernameOrPasswordException;
import spring.listsmicroservice.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/list")
public class Controller {
    private final WishService wishService;
    private final VisitedService visitedService;
    private final FavoritesService favoritesService;
    private final UserService userService;

    public Controller(WishService wishService, VisitedService visitedService, FavoritesService favoritesService, UserService userService) {
        this.wishService = wishService;
        this.visitedService = visitedService;
        this.favoritesService = favoritesService;
        this.userService = userService;
    }

    /*Returns all wishlist monuments for the given user if the user is logged in */

    @GetMapping("/wishlist/{username}")
    public List<Monument> wishlist(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent())
            return wishService.getWishList(username);
        else
            return null;
    }

    /*Returns all visited monuments for the given user if the user is logged in */

    @GetMapping("/visited/{username}")
    public List<Monument> visited(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent())
            return visitedService.getVisitedList(username);
        else
            return null;
    }

    /*Returns all favourite monuments for the given user if the user is logged in */

    @GetMapping("/favourites/{username}")
    public List<Monument> favourites(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent())
            return favoritesService.getFavoritesList(username);
        else
            return null;
    }

    @PostMapping("/wishlist/{name}")
    public ResponseEntity<String> addToWishList(@PathVariable String name, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            wishService.addToWishList(user.getUsername(), name);
            return ResponseEntity.ok("addedToWish");
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }

    @PostMapping("/visited/{name}")
    public ResponseEntity<String> addToVisited(@PathVariable String name, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            visitedService.addToVisitedList(user.getUsername(), name);
            return ResponseEntity.ok("addedToVisited");
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }

    @PostMapping("/favorites/{name}")
    public ResponseEntity<String> addToFavorites(@PathVariable String name, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            favoritesService.addToFavoritesList(user.getUsername(), name);
            return ResponseEntity.ok("addedToFavorites");
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }
}
