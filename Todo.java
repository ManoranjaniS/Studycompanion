package mano.com.Practising.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String task;          // Task name/title
    private String description;
   // private boolean completed;    // Completion status

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAndTime;

    @Column(name = "completed") // 👈 Add this line!
    private boolean completed;
    // Constructors (Optional)
    public Todo() {}

    public Todo(String task, String description, boolean completed, Date dateAndTime) {
        this.task = task;
        this.description = description;
        this.completed = completed;
        this.dateAndTime = dateAndTime;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public Date getDateAndTime() { return dateAndTime; }
    public void setDateAndTime(Date dateAndTime) { this.dateAndTime = dateAndTime; }
}
