package CSC_340_01.orchestra.Service;

import CSC_340_01.orchestra.Model.Follower;
import CSC_340_01.orchestra.Repository.FollowerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FollowerService {
    private final FollowerRepository followerRepository;

    public FollowerService(FollowerRepository followerRepository){
        this.followerRepository = followerRepository;
    }

    public List<Follower> getAllFollower(){
        return followerRepository.findAll();

    }

    //public Follower getFollowerById (long followerId){
        //return followerRepository.findById(followerId).orElse(null);
    //}

    public void addNewFollower(Follower follower){
        followerRepository.save(follower);
    }



}
