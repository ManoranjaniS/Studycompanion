package mano.com.Practising.service;

import mano.com.Practising.model.Todo;
import mano.com.Practising.repository.Todorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Todoservice {

    @Autowired
    private  Todorepository todorepository;

    // Fetch all todos
    public  List<Todo> getAllTodos() {
        return todorepository.findAll();
    }

    // Create or update a todo
    public Todo createTodo(Todo data) {
        return todorepository.save(data);
    }

    // Find a specific todo by ID
    public Optional<Todo> getTodoById(Long id) {
        return todorepository.findById(Math.toIntExact(id));
    }

    // Delete a todo by ID
    public void deleteTodo(Long id) {
        todorepository.deleteById(Math.toIntExact(id));
    }
}
