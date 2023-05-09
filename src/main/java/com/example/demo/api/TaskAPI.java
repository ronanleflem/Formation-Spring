package com.example.demo.api;

import com.example.demo.dto.TaskDTO;
import com.example.demo.modele.Task;
import com.example.demo.modele.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.service.TaskService;

@RestController
public class TaskAPI {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/task/allTasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody TaskDTO taskDTO) {
        taskDTO.setDueDate(new Date());
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setDueDate(taskDTO.getDueDate());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.getCompleted());
        System.out.println("ID USER :"+taskDTO.getIdUser());
        System.out.println("USER:");
        System.out.println(userService.getUserById(taskDTO.getIdUser()));

        User user = userService.getUserById(taskDTO.getIdUser()).orElse(null);
        task.setUser(user);
        return taskService.saveTask(task);
    }

    @PutMapping("task/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Optional<Task> optionalTask = taskService.getTaskById(id);
        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setDueDate(task.getDueDate());
            existingTask.setCompleted(task.isCompleted());
            existingTask.setUser(task.getUser());
            return new ResponseEntity<>(taskService.saveTask(existingTask), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("task/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        Optional<Task> optionalTask = taskService.getTaskById(id);
        if (optionalTask.isPresent()) {
            taskService.deleteTaskById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
