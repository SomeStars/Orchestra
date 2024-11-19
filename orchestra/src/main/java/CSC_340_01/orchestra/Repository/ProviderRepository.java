package CSC_340_01.orchestra.Repository;

import CSC_340_01.orchestra.Model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
