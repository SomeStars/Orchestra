package CSC_340_01.orchestra.Repository;

import CSC_340_01.orchestra.Model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("SELECT l FROM Like l WHERE l.songId = :songId")
    Optional<Like> findBySongId(@Param("songId") long songId);
}
