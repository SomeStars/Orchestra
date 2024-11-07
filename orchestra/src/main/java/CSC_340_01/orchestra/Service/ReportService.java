package CSC_340_01.orchestra.Service;

import CSC_340_01.orchestra.Model.Report;
import CSC_340_01.orchestra.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllSongReports() {
        return reportRepository.findBySongIdIsNotNull();
    }

    public List<Report> getAllReviewReports() {
        return reportRepository.findByReviewIdIsNotNull();
    }

    public Report createReport(Report report) {
        report.setStatus("pending"); // Default status for new reports
        return reportRepository.save(report);
    }

    public Report updateReportStatus(Long reportId, String newStatus) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Report not found"));
        report.setStatus(newStatus);
        return reportRepository.save(report);
    }
}
