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
    private String username;
    private String profile_image_url;
    private String payment_url;

    // constructor
    public Provider() {

    }

    // getters and setters
    public Long getProvider_id() { return provider_id; }

    public void setProvider_id(Long provider_id) { this.provider_id = provider_id; }

    public String getBio() { return bio; }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileImage() {
        return profile_image_url;
    }

    public void setProfileImage(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getPaymentUrl() {
        return payment_url;
    }

    public void setPaymentUrl(String payment_url) {
        this.payment_url = payment_url;
    }
}