package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.Report;
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

    @GetMapping("/songs")
    public List<Report> getAllSongReports() {
        return reportService.getAllSongReports();
    }

    @GetMapping("/reviews")
    public List<Report> getAllReviewReports() {
        return reportService.getAllReviewReports();
    }

    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        Report savedReport = reportService.saveReport(report);
        return new ResponseEntity<>(savedReport, HttpStatus.CREATED);
    }

    @PutMapping("/{reportId}/status")
    public Report updateReportStatus(@PathVariable Long reportId, @RequestParam String status) {
        return reportService.updateReportStatus(reportId, status);
    }
}
