package CSC_340_01.orchestra.Repository;

import CSC_340_01.orchestra.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
