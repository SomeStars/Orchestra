package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.Follower;
import CSC_340_01.orchestra.Service.FollowerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/followers")
public class FollowerController {
    private final FollowerService followerService;

    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @GetMapping
    public List<Follower> getAllFollower() {
        return followerService.getAllFollower();
    }

    @PostMapping("/newFollower")
    public List<Follower> addNewFollower(@RequestBody Follower follower){
        followerService.addNewFollower(follower);
        return followerService.getAllFollower();
    }

}
