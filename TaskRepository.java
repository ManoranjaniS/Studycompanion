package studycompanion.repository;

import studycompanion.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // No need to define findById, it's inherited from JpaRepository
}
