package CSC_340_01.orchestra.Service;

import CSC_340_01.orchestra.Model.Like;
import CSC_340_01.orchestra.Repository.LikeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LikeService {
    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    public Like getLikesBySongId(long SongId){
        return likeRepository.findBySongId(SongId).orElse(null);
    }

    public void addNewLike(Like like){
        likeRepository.save(like);
    }
}
