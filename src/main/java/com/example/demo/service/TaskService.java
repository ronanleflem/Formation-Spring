package com.example.demo.service;

import com.example.demo.dao.TaskDAO;
import com.example.demo.modele.Task;
import com.example.demo.modele.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskDAO taskDAO;

    public List<Task> getAllTasks() {
        return taskDAO.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskDAO.findById(id);
    }

    @Transactional
    public Task saveTask(Task task) {
        return taskDAO.save(task);
    }

    @Transactional
    public void deleteTaskById(Long id) {
        taskDAO.deleteById(id);
    }
}




