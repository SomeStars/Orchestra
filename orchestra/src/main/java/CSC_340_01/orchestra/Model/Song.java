package CSC_340_01.orchestra.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long song_id;

    private String title;
    private String genre;

    @Column(name = "release_date", nullable = false, insertable = false, updatable = false, columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date release_date;

    private String file_url;
    private String description;

    // constructor
    public Song() {

    }

    // getters and setters
    public Long getUserId() {
        return song_id;
    }

    public void setUserId(Long song_id) { this.song_id = song_id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(Date release_date) {
        this.release_date = release_date;
    }

    public String getFileUrl() {
        return file_url;
    }

    public void setFileUrl(String file_url) { this.file_url = file_url; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}