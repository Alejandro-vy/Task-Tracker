package avera.Task_Tracker.model;

import java.time.LocalDateTime;

public class Task {

    private String id;

    private String description;

    private String status; // (todo, in-progres, done)

    private LocalDateTime createdAt; // Fecha y hora que se creo la tarea.

    private LocalDateTime updatedAt; // Feccha y hora que se actualizó por última vez la tarea.

    public Task(String id, String description, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public  Task (String id, String description, String status){
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    public void updateTask(String newDescription, String newStatus) {
        this.description = newDescription;
        this.status = newStatus;
        this.updatedAt = LocalDateTime.now();
    }



}
