package avera.Task_Tracker.service;

import avera.Task_Tracker.model.Task;
import avera.Task_Tracker.repository.TaskRepository;

import java.util.List;
import java.util.UUID;


public class TaskService {

    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public void addTask (String description){

        String id = UUID.randomUUID().toString();
        Task newTask = new Task(id, description, "todo");
        List<Task> tasks = taskRepository.getTasks();
        tasks.add(newTask);
        taskRepository.saveTasks(tasks);



    }


    public void updateTask(String id, String newDescription, String newStatus) {
        List<Task> tasks = taskRepository.getTasks();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.updateTask(newDescription, newStatus);
                break;
            }
        }
        taskRepository.saveTasks(tasks);
    }

    public void deleteTask (Task task){

        task.getId();




    }


    public void changeStatus (String id, String newStatus){

        List<Task> tasks = taskRepository.getTasks();

        for (Task task : tasks){
            if (task.getId().equals(id)){
                task.setStatus(newStatus);

                break;
            }

            taskRepository.saveTasks(tasks);
        }


    }


    public List<Task> getTaskList (){

        return taskRepository.getTasks();
    }


}
