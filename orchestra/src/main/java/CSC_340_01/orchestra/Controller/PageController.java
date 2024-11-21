package CSC_340_01.orchestra.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // route for the home page
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    // route for the admin panel
    @GetMapping("/admin")
    public String showAdminPage() {
        return "admin";
    }

    // route for the manage users page
    @GetMapping("/users")
    public String showManageUsersPage() {
        return "manage-users";
    }

    // route for the reports page
    @GetMapping("/reports")
    public String showReportsPage() {
        return "view-reports";
    }

    // route for provider page
    @GetMapping("/provider")
    public String showProvider() {
        return "profile";
    }

    // route to login page
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

}
