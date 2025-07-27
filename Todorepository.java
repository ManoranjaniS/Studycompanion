package mano.com.Practising.repository;

import mano.com.Practising.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Todorepository  extends JpaRepository<Todo, Integer> {

}
