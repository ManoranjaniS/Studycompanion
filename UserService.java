package studycompanion.service;

import studycompanion.model.User;
import studycompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        userRepository.save(user);
    }

    public User validateLogin(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password) ? user : null;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}