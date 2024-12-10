package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.User;
import CSC_340_01.orchestra.Repository.ReportRepository;
import CSC_340_01.orchestra.Repository.ReviewRepository;
import CSC_340_01.orchestra.Repository.SongRepository;
import CSC_340_01.orchestra.Repository.UserRepository;
import CSC_340_01.orchestra.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.Option;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final ReportRepository reportRepository;

    private PasswordEncoder passwordEncoder;

    private final UserService userService;

    private AuthenticationManager authenticationManager;

    public UserController(UserService userService, ReviewRepository reviewRepository, ReportRepository reportRepository) {
        this.userService = userService;
        this.reviewRepository = reviewRepository;
        this.reportRepository = reportRepository;
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    @PostMapping("/index")
    public String showIndex(){
        return "index";
    }

    @PostMapping("/userLogin")
    public String userLogin(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.getPassword().equals(password)) {
                return "index";
            } else {
                redirectAttributes.addFlashAttribute("error", "Wrong Credentials");
                return "login";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Not a user");
            return "login";

        }
    }

    @GetMapping("/create")
    public String showCreateUserPage(){
        return "createUser";
    }

    @PostMapping("/create-login")
    public String createUser(@RequestParam String email, @RequestParam String role, @RequestParam String username, @RequestParam String password, @RequestParam String confirmPassword, RedirectAttributes redirectAttributes){
        Optional<User> emailExists = userRepository.findByEmail(email);
        if (emailExists.isPresent()){
            redirectAttributes.addFlashAttribute("error", "email already exists");
            return "create";
        }


        Optional<User> usernameExists = userRepository.findByUsername(username);
        if (usernameExists.isPresent()){
            redirectAttributes.addFlashAttribute("error", "Username already exists. Pick another Username.");
            return "create";
        }

        User newAccount = new User();
        newAccount.setUsername(username);
        newAccount.setPassword(password);
        newAccount.setEmail(email);
        newAccount.setRole(role);
        userRepository.save(newAccount);

        return "login";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "manage-users";
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

    @PutMapping("/update/{userId}")
    public User updateUser(@PathVariable long userId, @RequestBody User user){
        userService.updateUser(userId, user);
        return userService.getUserById(userId);
    }

    // delete a user
    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        try {
            // Delete related entities if necessary
            reviewRepository.deleteAllByUserId(userId);
            reportRepository.deleteAllByUserId(userId);

            userRepository.deleteById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error";
        }

        return "redirect:/users/all";
    }

}
