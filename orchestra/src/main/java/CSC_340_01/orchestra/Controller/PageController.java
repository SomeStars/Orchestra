package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.Song;
import CSC_340_01.orchestra.Model.Review;

import CSC_340_01.orchestra.Repository.ReportRepository;
import CSC_340_01.orchestra.Repository.ReviewRepository;
import CSC_340_01.orchestra.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;
import java.util.ArrayList;

@Controller
public class PageController {

    @Autowired
    private ReportRepository reportRepository;

    private final SongRepository songRepository;
    private final ReviewRepository reviewRepository;

    public PageController(SongRepository songRepository, ReviewRepository reviewRepository) {
        this.songRepository = songRepository;
        this.reviewRepository = reviewRepository;
    }

    // route for the home page
    @GetMapping("/index")
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

    // show the create report page
    @GetMapping("/reports/create")
    public String createReportPage(Model model) {

        List<Song> songs = songRepository.findAll();
        List<Review> reviews = reviewRepository.findAll();

        // create a unified list of options
        List<String> reportableContent = new ArrayList<>();
        for (Song song : songs) {
            reportableContent.add(song.getUserId() + " - Song");
        }
        for (Review review : reviews) {
            reportableContent.add(review.getReviewId() + " - Review");
        }

        model.addAttribute("reportableContent", reportableContent);
        return "create-report";
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

    @GetMapping("/success-page")
    public String showSuccessPage() {
        return "success-page";
    }

    @GetMapping("/upload-music")
    public String showUploadMusicPage() {
        return "upload-music";
    }
}
