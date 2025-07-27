package mano.com.Practising.controller;

import mano.com.Practising.model.Todo;
import mano.com.Practising.repository.Todorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    @Autowired
    private Todorepository repository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("todos", repository.findAll());
        return "todolist";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("todo") Todo todo) {
        repository.save(todo);
        return "redirect:/";
    }
}
