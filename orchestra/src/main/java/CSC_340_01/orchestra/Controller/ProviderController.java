package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.Provider;
import CSC_340_01.orchestra.Model.Provider;
import CSC_340_01.orchestra.Model.Provider;
import CSC_340_01.orchestra.Service.ProviderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @PostMapping("/new")
    public List<Provider> addNewProvider(@RequestBody Provider provider) {
        providerService.addNewProvider(provider);
        return providerService.getAllProviders();
    }

    @PutMapping("/update/{provider_id}")
    public Provider updateProvider(@PathVariable long providerId, @RequestBody Provider provider){
        providerService.updateProvider(providerId, provider);
        return providerService.getProviderById(providerId);
    }

    @GetMapping("/delete/{provider_id}")
    public String deleteAnimal(@PathVariable int providerId) {
        providerService.deleteProvider(providerId);
        return "/api/providers";
    }
}