package CSC_340_01.orchestra.Repository;

import CSC_340_01.orchestra.Model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepository extends JpaRepository<Follower, Long> {
}
