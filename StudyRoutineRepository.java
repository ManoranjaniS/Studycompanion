package studycompanion.repository;

import studycompanion.model.StudyRoutine;
import studycompanion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRoutineRepository extends JpaRepository<StudyRoutine, Long> {
    List<StudyRoutine> findByUser(User user);
}
