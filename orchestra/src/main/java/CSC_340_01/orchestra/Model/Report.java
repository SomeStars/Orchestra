package CSC_340_01.orchestra.Model;

import jakarta.persistence.*;
import CSC_340_01.orchestra.Model.User;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @Column(name = "song_id", nullable = true)
    private Long songId; // nullable, foreign key for songs

    @Column(name = "review_id", nullable = true)
    private Long reviewId; // nullable, foreign key for reviews

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "report_reason")
    private String reason;

    private String status;

    // constructor
    public Report() {}

    public Report(String reason, Long songId, Long reviewId, Long userId) {
        this.reason = reason;
        this.songId = songId;
        this.reviewId = reviewId;
        this.userId = userId;
        this.status = "pending"; // default status
    }

    // getters and setters
    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
