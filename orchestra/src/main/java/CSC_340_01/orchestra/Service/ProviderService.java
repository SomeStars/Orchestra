package CSC_340_01.orchestra.Service;

import CSC_340_01.orchestra.Model.Provider;
import CSC_340_01.orchestra.Repository.ProviderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }
}
