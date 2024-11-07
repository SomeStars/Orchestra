package CSC_340_01.orchestra.Repository;

import CSC_340_01.orchestra.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findBySongIdIsNotNull();
    List<Report> findByReviewIdIsNotNull();
}
