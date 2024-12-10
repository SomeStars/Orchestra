package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.Report;
import CSC_340_01.orchestra.Model.Review;

import CSC_340_01.orchestra.Model.Song;
import CSC_340_01.orchestra.Repository.ReportRepository;
import CSC_340_01.orchestra.Repository.SongRepository;
import CSC_340_01.orchestra.Repository.ReviewRepository;
import CSC_340_01.orchestra.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    private final ReportRepository reportRepository;
    private final SongRepository songRepository;
    private final ReviewRepository reviewRepository;

    public ReportController(ReportRepository reportRepository, SongRepository songRepository, ReviewRepository reviewRepository) {
        this.reportRepository = reportRepository;
        this.songRepository = songRepository;
        this.reviewRepository = reviewRepository;
    }

    // get a list of all reports
    @GetMapping("/all")
    public String getAllReports(Model model) {
        List<Report> songReports = reportService.getAllSongReports();
        List<Report> reviewReports = reportService.getAllReviewReports();

        model.addAttribute("songReports", songReports);
        model.addAttribute("reviewReports", reviewReports);

        return "view-reports";
    }

    // delete a report
    @GetMapping("/delete/{id}")
    public String deleteReport(@PathVariable Long id) {
        reportService.deleteReportById(id);
        return "redirect:/reports/all";
    }

    // create a new report
    @PostMapping("/create")
    public String createReport(@RequestParam("reportableContent") String contentId,
                               @RequestParam("reportReason") String reason,
                               @RequestParam("userId") Long userId) {
        try {
            // Split the content string into ID and type
            String[] parts = contentId.split(" - ");
            Long id = Long.parseLong(parts[0]);
            String type = parts[1];

            // Create a new report
            Report newReport = new Report();
            if (type.equalsIgnoreCase("Song")) {
                newReport.setSongId(id);
            } else if (type.equalsIgnoreCase("Review")) {
                newReport.setReviewId(id);
            }

            newReport.setReason(reason);
            newReport.setUserId(userId);
            newReport.setStatus("pending");

            reportRepository.save(newReport);

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error";
        }

        return "redirect:/reports/all";
    }

    @GetMapping("/ignore/{reportId}")
    public String ignoreReport(@PathVariable Long reportId) {
        try {
            Report report = reportRepository.findById(reportId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid report ID"));
            report.setStatus("ignored");
            reportRepository.save(report);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error";
        }
        return "redirect:/reports/all";
    }

    @GetMapping("/delete-review/{reviewId}")
    public String deleteReview(@PathVariable Long reviewId) {
        try {
            reviewRepository.deleteById(reviewId);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error";
        }
        return "redirect:/reports/all";
    }

    /* view the details of a single report
    @GetMapping("/{reportId}")
    public Report getReportById(@PathVariable Long reportId) {
        return reportService.getReportById(reportId);
    }

    // create a new report
    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        Report savedReport = reportService.saveReport(report);
        return ResponseEntity.ok(savedReport);
    }

    // update the status of a report
    @PutMapping("/{reportId}/status")
    public Report updateReportStatus(@PathVariable Long reportId, @RequestParam String status) {
        return reportService.updateReportStatus(reportId, status);
    }*/
}
