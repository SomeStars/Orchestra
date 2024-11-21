package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.Report;
import CSC_340_01.orchestra.Repository.ReportRepository;
import CSC_340_01.orchestra.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
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
