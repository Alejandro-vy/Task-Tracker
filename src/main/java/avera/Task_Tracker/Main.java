package avera.Task_Tracker;

import avera.Task_Tracker.model.Task;
import avera.Task_Tracker.repository.TaskRepository;
import avera.Task_Tracker.service.TaskService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository("tasks.json");
        TaskService taskService = new TaskService(repository);
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Bienvenido al Task Tracker. Ingrese comandos para gestionar las tareas.");

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine().trim();
            String[] parts = command.split(" ", 2);
            String action = parts[0];

            switch (action) {
                case "add":
                    String description = parts.length > 1 ? parts[1] : "";
                    taskService.addTask(description);
                    System.out.println("Tarea agregada.");
                    break;
                case "update":
                    // Implementa lógica para actualizar
                    break;
                case "delete":
                    // Implementa lógica para eliminar
                    break;
                case "list":
                    List<Task> tasks = taskService.getTaskList();
                    tasks.forEach(task -> System.out.println(task.getDescription()));
                    break;
                case "list-todo":
                    // Lógica para listar tareas no completadas
                    break;
                case "exit":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Comando no reconocido.");
            }
        }
    }
}
