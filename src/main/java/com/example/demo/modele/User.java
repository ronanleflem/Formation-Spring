package com.example.demo.modele;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jdk.jfr.Enabled;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "FORMATION_USER")
public class User implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
    @JsonManagedReference
    private List<Task> lstTask;

    // constructeurs, getters, setters, etc.
}