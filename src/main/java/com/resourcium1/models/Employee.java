package com.resourcium1.models;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import java.util.Date;

//@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private Date hireDate;

//    @ManyToOne
//    @JoinColumn(name = "department_id")
//    private Department department;
//
//    @ManyToMany(mappedBy = "employees")
//    private Set<Task> tasks = new HashSet<>();

    // getters and setters
}
