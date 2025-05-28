package studycompanion.service;
import studycompanion.model.Goal;
import studycompanion.model.User;
import studycompanion.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {
    @Autowired
    private GoalRepository goalRepository;

    public void save(Goal goal) {
        goalRepository.save(goal);
    }

    public List<Goal> getGoalsByUser(User user) {
        return goalRepository.findByUser(user);
    }

    public int calculateProgress(User user) {
        // Stub logic, replace with real progress calculation
        return 85; // Example: 85% completed
    }
}