package studycompanion.repository;

import studycompanion.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
    List<SubTask> findByTask_Id(Long taskId);
}
