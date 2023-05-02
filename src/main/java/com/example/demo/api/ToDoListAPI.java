package com.example.demo.api;

import com.example.demo.modele.ToDoListItem;
import com.example.demo.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoListAPI {

    @Autowired
    private ToDoListService toDoListService;

    public ToDoListAPI(ToDoListService toDoListService){
        this.toDoListService = toDoListService;
    }
    @PostMapping("/add")
    public ResponseEntity<Boolean> addItem(@RequestBody ToDoListItem toDoListItem){
        return ResponseEntity.ok(toDoListService.addItem(toDoListItem.getName(),toDoListItem.getDescription()));
    }

    @GetMapping("/delete/{name}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable String name){
        return ResponseEntity.ok(toDoListService.deleteItem(name));
    }

    @GetMapping("/read/{name}")
    public ResponseEntity<ToDoListItem> readItem(@PathVariable String name){
        ToDoListItem toDoListItem = toDoListService.readItem(name);
        return ResponseEntity.ok(toDoListItem);
    }
}
