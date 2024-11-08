package CSC_340_01.orchestra.Service;

import CSC_340_01.orchestra.Model.User;
import CSC_340_01.orchestra.Model.Report;
import CSC_340_01.orchestra.Repository.ReportRepository;
import CSC_340_01.orchestra.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;
    private UserRepository userRepository;

    // return a list of all reports
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // return a list of all song reports
    public List<Report> getAllSongReports() {
        return reportRepository.findBySongIdIsNotNull();
    }

    // return a list of all review reports
    public List<Report> getAllReviewReports() {
        return reportRepository.findByReviewIdIsNotNull();
    }

    // update the status of a report
    public Report updateReportStatus(Long reportId, String newStatus) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Report not found"));
        report.setStatus(newStatus);
        return reportRepository.save(report);
    }

    // save a new report
    public Report saveReport(Report report) {
        if (report.getStatus() == null) {
            report.setStatus("pending");
        }
        return reportRepository.save(report);
    }
}
