package com.example.demo.modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "TASK")
public class Task implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Date dueDate;

    @Column
    private boolean completed;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinColumn(name="FORMATION_USER_ID")
    @JsonBackReference
    private User user;


}
