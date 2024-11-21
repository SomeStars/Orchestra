package CSC_340_01.orchestra.Controller;

import CSC_340_01.orchestra.Model.Provider;
import CSC_340_01.orchestra.Service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProviderController {
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/providers")
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

    @PostMapping("/update/{provider_id}")
    public String updateProvider(
            @PathVariable long provider_id,
            @RequestParam String bio,
            @RequestParam String payment_url) {

        // Create a new Provider object with updated data
        Provider updatedProvider = new Provider();
        updatedProvider.setProvider_id(provider_id);
        updatedProvider.setBio(bio);
        updatedProvider.setPaymentUrl(payment_url);

        // Call your service to update the provider in the database
        providerService.updateProvider(provider_id, updatedProvider);

        return "edit-profile";
    }


    @DeleteMapping("/delete/{provider_id}")
    public String deleteAnimal(@PathVariable int provider_id) {
        providerService.deleteProvider(provider_id);
        return "/profile/providers";
    }

    @GetMapping("/edit-profile/{provider_id}")
    public String showProfileEditor(@PathVariable("provider_id") Long provider_id, Model model) {
        // Fetch user data from database using provider_id
        Provider provider = providerService.getProviderById(provider_id);  // Your method to get user by provider_id

        // Add the provider object to the model so it can be accessed in the template
        model.addAttribute("provider", provider);

        return "edit-profile";
    }

}
