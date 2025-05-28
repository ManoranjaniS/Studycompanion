package studycompanion.controller;

import studycompanion.model.Goal;
import studycompanion.model.User;
import studycompanion.service.GoalService;
import studycompanion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class GoalController {

    @Autowired
    private GoalService goalService;

    @Autowired
    private UserService userService;

    @PostMapping("/setup-goal")
    public String setupGoal(@ModelAttribute Goal goal, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login"; // Handle invalid session
        }

        goal.setUser(user);
        goalService.save(goal);

        user.setNewUser(false);
        userService.save(user); // Persist the change

        return "redirect:/dashboard";
    }
}
