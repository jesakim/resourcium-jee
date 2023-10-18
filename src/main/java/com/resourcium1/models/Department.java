package com.resourcium1.models;

import jakarta.persistence.*;

//@Entity
//@Table(name = "departmentsddd")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

//    @OneToMany(mappedBy = "department")
//    private Set<Employee> employees = new HashSet<>();
//
//    @OneToMany(mappedBy = "department")
//    private Set<Equipment> equipment = new HashSet<>();

    // Constructors, if needed...

    // Getters and Setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }
//
//    public Set<Equipment> getEquipment() {
//        return equipment;
//    }
//
//    public void setEquipment(Set<Equipment> equipment) {
//        this.equipment = equipment;
//    }
}
