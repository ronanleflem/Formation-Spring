package com.example.demo;

import com.example.demo.dao.ToDoListItemDAO;
import com.example.demo.service.ToDoListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ToDoListConfiguration {

    @Bean
    public ToDoListService toDoListServiceConfig(ToDoListItemDAO toDoListItemDAO){
        return new ToDoListService(toDoListItemDAO);
    }






}
