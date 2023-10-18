package com.resourcium1.models;
import jakarta.persistence.*;

import java.util.Date;

//@Entity
@Table(name = "equipments")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;
    private Date purchaseDate;
    private Date maintenanceDate;
    private String status;

//    @ManyToOne
//    @JoinColumn(name = "department_id")
//    private Department department;
//
//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee assignedEmployee;

    // getters and setters
}