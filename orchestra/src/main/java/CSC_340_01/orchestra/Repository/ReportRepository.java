package CSC_340_01.orchestra.Repository;

import CSC_340_01.orchestra.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findBySongIdIsNotNull();
    List<Report> findByReviewIdIsNotNull();
    @Modifying
    @Query("DELETE FROM Review r WHERE r.userId = :userId")
    void deleteAllByUserId(@Param("userId") Long userId);
}
