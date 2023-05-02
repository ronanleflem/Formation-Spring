package com.example.demo.dao;

import com.example.demo.modele.ToDoListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListItemDAO extends JpaRepository<ToDoListItem,Long> {
    public ToDoListItem findByName(String name);

    public ToDoListItem save(ToDoListItem item);

    public void deleteByName(String name);
}
