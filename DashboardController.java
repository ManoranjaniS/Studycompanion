package studycompanion.controller;

import studycompanion.model.User;
import studycompanion.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @Autowired
    private GoalService goalService;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login"; // If session expired or not logged in
        }

        if (user.isNewUser()) {
            return "setup-goal"; // View for setting initial goal/tasks
        }

        model.addAttribute("goals", goalService.getGoalsByUser(user));
        model.addAttribute("progress", goalService.calculateProgress(user));
        model.addAttribute("streak", user.getStreak());
        return "dashboard";
    }
}
