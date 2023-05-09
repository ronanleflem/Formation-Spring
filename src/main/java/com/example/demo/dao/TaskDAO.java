package com.example.demo.dao;

import com.example.demo.modele.Task;
import com.example.demo.modele.ToDoListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskDAO extends JpaRepository<Task, Integer> {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task save(Task task);
    void deleteById(Long id);
}
