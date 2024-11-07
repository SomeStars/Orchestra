package CSC_340_01.orchestra.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long provider_id;

    private String bio;
    private String profile_image_url;
    private String payment_url;

    // constructor
    public Provider() {

    }

    // getters and setters
    public Long getUserId() {
        return provider_id;
    }

    public void setUserId(Long userId) {
        this.provider_id = userId;
    }

    public String getUsername() {
        return bio;
    }

    public void setUsername(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return profile_image_url;
    }

    public void setEmail(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getPassword() {
        return payment_url;
    }

    public void setPassword(String payment_url) {
        this.payment_url = payment_url;
    }
}