package CSC_340_01.orchestra.Repository;

import CSC_340_01.orchestra.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {

}
