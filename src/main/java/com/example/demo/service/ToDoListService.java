package com.example.demo.service;

import com.example.demo.dao.ToDoListItemDAO;
import com.example.demo.modele.ToDoListItem;
import org.springframework.transaction.annotation.Transactional;

//@Service
public class ToDoListService {
    //private ToDoList toDoList = new ToDoList();

    private ToDoListItemDAO toDoListItemDAO;

    public ToDoListService(ToDoListItemDAO toDoListItemDAO){
        this.toDoListItemDAO = toDoListItemDAO;
    }
    @Transactional
    public boolean addItem(String name, String description) {
        toDoListItemDAO.save(new ToDoListItem(name,description));
        return true;
    }

    @Transactional
    public boolean deleteItem(String name) {
        toDoListItemDAO.deleteByName(name);
        return true;
    }

    public ToDoListItem readItem(String name) {
        return toDoListItemDAO.findByName(name);
    }
}
