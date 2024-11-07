package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.Like;
import CSC_340_01.orchestra.Model.Like;
import CSC_340_01.orchestra.Service.LikeService;
import CSC_340_01.orchestra.Service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like> getAllLike() {
        return likeService.getAllLikes();
    }

    @GetMapping("/{songId}")
    public List<Like> getLikesBySongId(@PathVariable long songId) {
        return (List<Like>) likeService.getLikesBySongId(songId);
    }

    @PostMapping("/new")
    public List<Like> addNewLike(@RequestBody Like like) {
        likeService.addNewLike(like);
        return likeService.getAllLikes();
    }

}