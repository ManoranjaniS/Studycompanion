package mano.com.Practising.controller;

import mano.com.Practising.service.GoalService;
import mano.com.Practising.service.QuoteService;
import mano.com.Practising.service.StreakService;
import mano.com.Practising.service.Todoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private GoalService goalService;

    @Autowired
    private Todoservice todoservice;

    @Autowired
    private StreakService streakService;

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("quote", quoteService.getRandomQuote());
        model.addAttribute("todos", todoservice.getAllTodos());
        model.addAttribute("goals", goalService.getAllGoals());
        model.addAttribute("streakCount", streakService.getStreak());
        return "dashboard"; // dashboard.html under templates
    }
}
