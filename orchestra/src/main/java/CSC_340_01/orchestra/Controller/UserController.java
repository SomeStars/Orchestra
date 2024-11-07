package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.User;
import CSC_340_01.orchestra.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable long userId){
        return userService.getUserById(userId);

    }

    @PostMapping("/newUser")
    public List<User> addNewUser(@RequestBody User user){
        userService.addNewUser(user);
        return userService.getAllUsers();
    }

    @PutMapping("/updateUser/{userId}")
    public User updateUser(@PathVariable long userId, @RequestBody User user){
        userService.updateUser(userId, user);
        return userService.getUserById(userId);
    }

}
