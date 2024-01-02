package imtiaj.restController;

import imtiaj.model.User;
import imtiaj.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        userService.create(user);
        return "Successful Insert";
    }

    @PutMapping("/{users}")
    public String updateUser(@PathVariable("users") int users, @RequestBody User user) {

        userService.edit(user);
        return "Successful Update";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/count")
    public int getTotalUserCount() {
        return userService.getAll().size();
    }

    @GetMapping("/users/{id}")
    public User infoUser(@PathVariable("id") int id) {
        return userService.get(id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "Successful Delete";
    }

}
