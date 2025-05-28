package studycompanion.service;

import studycompanion.model.User;
import studycompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreakService {
    @Autowired
    private UserRepository userRepository;

    public void updateStreak(User user, boolean studiedToday) {
        if (studiedToday) {
            user.setStreak(user.getStreak() + 1);
        } else {
            user.setStreak(0);
        }
        userRepository.save(user);
    }
}