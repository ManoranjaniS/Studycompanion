package mano.com.Practising.controller;


import mano.com.Practising.model.Goal;
import mano.com.Practising.repository.GoalRepository;
import mano.com.Practising.service.StreakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/goals")
public class Goalcontroller {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private StreakService streakService;

    // Create a new goal
    @PostMapping
    public Goal createGoal(@RequestBody Goal goal) {
        return goalRepository.save(goal);
    }

    // Get all goals
    @GetMapping
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    // Get goal by ID
    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long id) {
        Optional<Goal> optional = goalRepository.findById(id);
        return optional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update goal and update streak if marked completed
    @PutMapping("/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable Long id, @RequestBody Goal updatedGoal) {
        return goalRepository.findById(id)
                .map(goal -> {
                    boolean wasCompleted = goal.isCompleted();
                    boolean nowCompleted = updatedGoal.isCompleted();

                    goal.setCategory(updatedGoal.getCategory());
                    goal.setTitle(updatedGoal.getTitle());
                    goal.setDescription(updatedGoal.getDescription());
                    goal.setTargetDate(updatedGoal.getTargetDate());
                    goal.setCompleted(nowCompleted);

                    Goal savedGoal = goalRepository.save(goal);

                    // If it wasn't completed before but is now, update the streak
                    if (!wasCompleted && nowCompleted) {
                        streakService.updateStreak();
                    }

                    return ResponseEntity.ok(savedGoal);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Delete goal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {
        if (!goalRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        goalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
