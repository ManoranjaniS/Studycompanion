package mano.com.Practising.service;

import mano.com.Practising.model.Streak;
import mano.com.Practising.repository.StreakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StreakService {

    @Autowired
    StreakRepository repository;

    public  Streak getStreak() {
        List<Streak> streaks = repository.findAll();

        if (streaks.isEmpty()) {
            Streak newStreak = new Streak();
            newStreak.setCount(0);
            newStreak.setLastUpdatedDate(LocalDate.now());
            return repository.save(newStreak);
        }

        return streaks.get(0); // Return the existing streak
    }

    public Streak updateStreak() {
        Streak streak = getStreak();
        LocalDate today = LocalDate.now();

        if (streak.getLastUpdatedDate() != null && streak.getLastUpdatedDate().equals(today.minusDays(1))) {
            streak.setCount(streak.getCount() + 1); // Continued streak
        } else if (!today.equals(streak.getLastUpdatedDate())) {
            streak.setCount(1); // Reset or first update
        }

        streak.setLastUpdatedDate(today);
        return repository.save(streak);
    }
}
