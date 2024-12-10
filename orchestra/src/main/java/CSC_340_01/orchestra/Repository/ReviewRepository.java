package CSC_340_01.orchestra.Repository;

import CSC_340_01.orchestra.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Modifying
    @Query("DELETE FROM Review r WHERE r.userId = :userId")
    void deleteAllByUserId(@Param("userId") Long userId);
}
