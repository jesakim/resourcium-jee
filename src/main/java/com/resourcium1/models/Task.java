package com.resourcium1.models;
import jakarta.persistence.*;

import java.util.Date;


//@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private Date deadline;
    private String priority;
    private String status;

//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee assignedEmployee;

    // getters and setters
}
