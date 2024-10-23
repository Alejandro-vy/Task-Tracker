package avera.Task_Tracker.controller;

import avera.Task_Tracker.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

public class TaskTrackerApp implements CommandLineRunner {


    private TaskService taskService;

    public static void main(String[] args) {
        SpringApplication.run(TaskTrackerApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            String command = args[0];
            switch (command) {
                case "add":
                    taskService.addTask(args[1]);
                    break;
                case "update":
                    taskService.updateTask(args[1], args[2], args[3]); // id, newDescription, newStatus
                    break;
                case "list":
                    taskService.getTaskList();
                    break;
                case "delete":
                    taskService.deleteTask(args[1]);
                    break;
                case "list-status":
                    taskService.getTaskListStatus(args[1]);
                    break;
                default:
                    System.out.println("Comando no reconocido.");
                    break;
            }
        } else {
            System.out.println("Por favor, ingresa un comando.");
        }
    }
}

