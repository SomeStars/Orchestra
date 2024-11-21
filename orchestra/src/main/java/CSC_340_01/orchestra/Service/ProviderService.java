package CSC_340_01.orchestra.Service;

import CSC_340_01.orchestra.Model.Provider;
import CSC_340_01.orchestra.Repository.ProviderRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Provider getProviderById(long provider_id){
        return providerRepository.findById(provider_id).orElse(null);
    }

    public void addNewProvider(Provider provider){
        providerRepository.save(provider);
    }

    public void updateProvider(long provider_id, Provider provider){
        Provider existing = getProviderById(provider_id);
        existing.setBio(provider.getBio());
        existing.setProfileImage(provider.getProfileImage());
        existing.setPaymentUrl(provider.getPaymentUrl());

        providerRepository.save(existing);
    }

    public void deleteProvider(int providerId) {
        Provider existingProvider = providerRepository.findById((long) providerId)
                .orElseThrow(() -> new EntityNotFoundException("Provider with ID: " + providerId + " does not exist."));
        providerRepository.deleteById((long) providerId);
    }
}
