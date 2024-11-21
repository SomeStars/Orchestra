package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.Provider;
import CSC_340_01.orchestra.Service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/providers")
public class ProviderController {
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GetMapping("/{provider_id}")
    public String getProviderProfile(@PathVariable("provider_id") Long provider_id, Model model) {
        // Fetch provider data using the service method
        Provider provider = providerService.getProviderById(provider_id);

        // Add the provider object to the model so it can be accessed in the template
        model.addAttribute("provider", provider);

        // Return the name of the Thymeleaf template
        return "profile";  // This will resolve to "src/main/resources/templates/profile.html"
    }


    @PostMapping("/new")
    public List<Provider> addNewProvider(@RequestBody Provider provider) {
        providerService.addNewProvider(provider);
        return providerService.getAllProviders();
    }

    @PutMapping("/update/{provider_id}")
    public Provider updateProvider(@PathVariable long provider_id, @RequestBody Provider provider){
        providerService.updateProvider(provider_id, provider);
        return providerService.getProviderById(provider_id);
    }

    @DeleteMapping("/delete/{provider_id}")
    public String deleteAnimal(@PathVariable int provider_id) {
        providerService.deleteProvider(provider_id);
        return "/api/providers";
    }
}