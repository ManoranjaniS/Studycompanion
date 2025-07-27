package mano.com.Practising.service;

import mano.com.Practising.model.Goal;
import mano.com.Practising.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
  public   GoalRepository goalRepository;

    // Create a new goal
    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    // Get all goals
    public  List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    // Get a goal by its ID
    public Optional<Goal> getGoalById(Long id) {
        return goalRepository.findById(id);
    }

    // Update a goal by ID
    public Optional<Goal> updateGoal(Long id, Goal updatedGoal) {
        return goalRepository.findById(id).map(goal -> {
            goal.setCategory(updatedGoal.getCategory());
            goal.setTitle(updatedGoal.getTitle());
            goal.setDescription(updatedGoal.getDescription());
            goal.setTargetDate(updatedGoal.getTargetDate());
            goal.setCompleted(updatedGoal.isCompleted());
            return goalRepository.save(goal);
        });
    }

    // Delete a goal by ID
    public boolean deleteGoal(Long id) {
        if (goalRepository.existsById(id)) {
            goalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
