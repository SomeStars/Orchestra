package CSC_340_01.orchestra.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "song_id", nullable = false)
    private Long songId;

    @Column(name = "rating")
    private double rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "reported")
    private int numberOfReports = 0;

    public Review() {}

    public Review(Long userId, Long songId, double rating, String comment, Date createdAt) {
        this.userId = userId;
        this.songId = songId;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
        this.numberOfReports = 0;
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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

}
