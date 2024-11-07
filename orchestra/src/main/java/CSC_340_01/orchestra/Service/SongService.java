package CSC_340_01.orchestra.Service;

import CSC_340_01.orchestra.Model.Song;
import CSC_340_01.orchestra.Repository.SongRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
}
