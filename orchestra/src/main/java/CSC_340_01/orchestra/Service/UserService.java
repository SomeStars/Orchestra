package CSC_340_01.orchestra.Service;

import CSC_340_01.orchestra.Model.Provider;
import CSC_340_01.orchestra.Model.User;
import CSC_340_01.orchestra.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public void addNewUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(int userId){
        User exhistingUser = userRepository.findById((long) userId)
                .orElseThrow(() -> new EntityNotFoundException("User with ID: " + userId + " does not exist."));
        userRepository.deleteById((long) userId);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void updateUser(long userId, User user){
        User existing = getUserById(userId);
        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setRole(user.getRole());

        userRepository.save(existing);
        }
    }

