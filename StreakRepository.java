package mano.com.Practising.repository;


import mano.com.Practising.model.Streak;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreakRepository extends JpaRepository<Streak, Long> {
}
