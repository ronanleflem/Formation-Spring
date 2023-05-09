package com.example.demo.dao;

import com.example.demo.modele.ToDoListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListItemDAO extends JpaRepository<ToDoListItem,Long> {
    ToDoListItem findByName(String name);

    ToDoListItem save(ToDoListItem item);

    void deleteByName(String name);
}
