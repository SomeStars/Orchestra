package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.Report;
import CSC_340_01.orchestra.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Report createReport(@RequestBody Report report) {
        return reportService.createReport(report);
    }

    @PutMapping("/{reportId}/status")
    public Report updateReportStatus(@PathVariable Long reportId, @RequestParam String status) {
        return reportService.updateReportStatus(reportId, status);
    }
}
