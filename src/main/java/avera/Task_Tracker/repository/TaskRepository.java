package avera.Task_Tracker.repository;

import avera.Task_Tracker.model.Task;
import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TaskRepository {

    private final Path filePath;

    // Inicializa el archivo JSON si no existe
    public TaskRepository(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    // Lee las tareas del archivo JSON
    public List<Task> getTasks() {
        try {
            String content = Files.readString(filePath);
            // Parsear el contenido JSON y devolver la lista de tareas
            return parseJson(content);
        } catch (IOException e) {
            System.out.println("Error al leer o procesar el archivo JSON: " + e.getMessage());
        }
        return null;
    }

    // Escribe la lista de tareas en el archivo JSON
    public void saveTasks(List<Task> tasks) {
        try {
            String jsonContent = convertToJson(tasks);
            Files.writeString(filePath, jsonContent);
        } catch (IOException e) {
            // Manejar errores
        }
    }

    private void createEmptyJson() {
        try {
            Files.writeString(filePath, "[]");  // Archivo JSON vacío
        } catch (IOException e) {
            // Manejar errores
        }
    }

    public List<Task> parseJson (String filePath) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));

        List<Task> tasks = objectMapper.readValue(jsonString, new TypeReference<List<Task>>() {
        });


        return tasks;

    }

    public String convertToJson (List<Task> tasks) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonStr = objectMapper.writeValueAsString(tasks);

        return jsonStr;

    }





}




