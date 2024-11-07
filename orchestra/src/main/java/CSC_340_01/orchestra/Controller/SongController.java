package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.Song;
import CSC_340_01.orchestra.Model.Song;
import CSC_340_01.orchestra.Service.SongService;
import CSC_340_01.orchestra.Service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getAllSong() {
        return songService.getAllSongs();
    }

    @PostMapping("/new")
    public List<Song> addNewSong(@RequestBody Song song) {
        songService.addNewSong(song);
        return songService.getAllSongs();
    }

}
