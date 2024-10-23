package avera.Task_Tracker.service;

import avera.Task_Tracker.model.Task;
import avera.Task_Tracker.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class TaskService {

    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public void addTask(String description) {

        String id = UUID.randomUUID().toString();
        Task newTask = new Task(id, description, "todo");
        newTask.setCreatedAt(LocalDateTime.now());
        List<Task> tasks = taskRepository.getTasks();
        tasks.add(newTask);
        taskRepository.saveTasks(tasks);


    }


    public void updateTask(String id, String newDescription, String newStatus) {
        List<Task> tasks = taskRepository.getTasks();
        boolean updated = false;
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.updateTask(newDescription, newStatus);
                task.setUpdatedAt(LocalDateTime.now()); // Actualizar fecha
                updated = true;
                break;
            }
        }
        if (updated) {
            taskRepository.saveTasks(tasks);
        } else {
            // Manejar caso de tarea no encontrada
            System.out.println("Tarea no encontrada");
        }
    }



    public void deleteTask(String id) {
        List<Task> tasks = taskRepository.getTasks();
        tasks.removeIf(task -> task.getId().equals(id)); // Eliminar por ID
        taskRepository.saveTasks(tasks);
    }


    public void changeStatus(String id, String newStatus) {
        List<Task> tasks = taskRepository.getTasks();
        boolean updated = false;
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(newStatus);
                task.setUpdatedAt(LocalDateTime.now()); // Actualizar fecha
                updated = true;
                break;
            }
        }
        if (updated) {
            taskRepository.saveTasks(tasks);
        } else {
            // Manejar caso de tarea no encontrada
            System.out.println("Tarea no encontrada");
        }
    }


    public List<Task> getTaskList() {

        return taskRepository.getTasks();
    }


    public List<Task> getTaskListStatus(String status) {
        List<Task> tasks = taskRepository.getTasks();
        // Filtrar las tareas según el estado
        return tasks.stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }


}
