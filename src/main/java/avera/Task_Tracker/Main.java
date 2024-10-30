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
                    String id = parts.length > 1 ? parts[1] : "";

                    String newDescription = parts.length > 2 ? parts[2] : "";

                    String newStatus = parts.length > 3 ? parts[3] : "";

                    taskService.updateTask(id,newDescription,newStatus);

                    System.out.println("Tarea actualizada. ");
                    break;
                case "delete":

                    String idDelete = parts.length > 1 ? parts[1] : "";


                    taskService.deleteTask(idDelete);
                    break;
                case "list":
                    List<Task> tasks = taskService.getTaskList();
                    tasks.forEach(task -> System.out.println(task.getDescription()));
                    break;
                case "list-todo":

                    taskService.getTaskListStatus("todo");

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
