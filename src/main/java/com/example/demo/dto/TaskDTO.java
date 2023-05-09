package com.example.demo.dto;

import com.example.demo.modele.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
public class TaskDTO {

    private Long id;

    private String title;

    private String description;

    private Date dueDate;

    private Boolean completed;

    private Long idUser;


}
