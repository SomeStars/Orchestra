package CSC_340_01.orchestra.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "followers")
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followId;
    private Long userId;
    private Long providerId;

    public Follower() {

    }

    public Long getFollowId(){
        return followId;
    }

    public void setFollowId(Long followId){
        this.followId = followId;
    }

    public Long getUserId(){
        return userId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public Long getProviderId(){
        return providerId;
    }

    public void setProviderId(Long providerId){
        this.providerId = providerId;
    }
}
