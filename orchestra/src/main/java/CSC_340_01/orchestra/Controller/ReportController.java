package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.Report;
import CSC_340_01.orchestra.Repository.ReportRepository;
import CSC_340_01.orchestra.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    private final ReportRepository reportRepository;

    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    // get a list of all reports
    @GetMapping()
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }
    // get a list of all reports on songs
    @GetMapping("/songs")
    public List<Report> getAllSongReports() {
        return reportService.getAllSongReports();
    }

    // get a list of all reports on reviews
    @GetMapping("/reviews")
    public List<Report> getAllReviewReports() {
        return reportService.getAllReviewReports();
    }

    // create a new report
    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        Report savedReport = reportService.saveReport(report);
        return new ResponseEntity<>(savedReport, HttpStatus.CREATED);
    }

    // update the status of a report
    @PutMapping("/{reportId}/status")
    public Report updateReportStatus(@PathVariable Long reportId, @RequestParam String status) {
        return reportService.updateReportStatus(reportId, status);
    }
}
