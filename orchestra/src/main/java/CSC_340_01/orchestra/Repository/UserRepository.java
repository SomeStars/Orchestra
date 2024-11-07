package CSC_340_01.orchestra.Repository;

import CSC_340_01.orchestra.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}