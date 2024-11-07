package CSC_340_01.orchestra.Service;

import CSC_340_01.orchestra.Model.Song;
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

    public Song getSongById(long songId){
        return songRepository.findById(songId).orElse(null);
    }
    public void addNewSong(Song song){
        songRepository.save(song);
    }

    public void updateSong(long songId, Song song){
        Song existing = getSongById(songId);
        existing.setTitle(song.getTitle());
        existing.setGenre(song.getGenre());
        existing.setReleaseDate(song.getReleaseDate());
        existing.setFileUrl(song.getFileUrl());
        existing.setDescription(song.getDescription());

        songRepository.save(existing);
    }
}
