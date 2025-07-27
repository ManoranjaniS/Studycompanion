package mano.com.Practising.controller;

import mano.com.Practising.model.Streak;
import mano.com.Practising.service.StreakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/streak")
public class StreakController {

    @Autowired
    private StreakService service;

    @PostMapping("/update")
    public Streak updateStreak() {
        return service.updateStreak();
    }

    @GetMapping
    public Streak getStreak() {
        return service.getStreak();
    }
}
