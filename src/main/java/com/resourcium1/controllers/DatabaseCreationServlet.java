package com.resourcium1.controllers;

import com.resourcium1.models.Equipment;
import com.resourcium1.models.Reservation;
import com.resourcium1.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DatabaseCreationServlet", value = "/creatDB",loadOnStartup = 1)
public class DatabaseCreationServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        create 10 Equipments objects AND 10 Reservation objects the save them
        for (int i = 0; i < 10; i++) {
            Reservation reservation = new Reservation();
            reservation.setStartDate(new java.sql.Date(System.currentTimeMillis()));
            reservation.setEndDate(new java.sql.Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000));
            reservation.setEquipmentId(i + 1);
            reservation.setEmployeeId(1);
            entityManager.persist(reservation);
        }
//        how to make hibernate id start from 1 -> persistence.xml -> <property name="hibernate.id.new_generator_mappings" value="false"/>
        for (int i = 0; i < 10; i++) {
            Equipment equipment = new Equipment();
            equipment.setName("Equipment " + i);
            equipment.setType("Type " + i);
            entityManager.persist(equipment);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
