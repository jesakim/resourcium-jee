package com.resourcium1.controllers;

import com.resourcium1.models.User;
import com.resourcium1.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.IOException;
import java.io.Serializable;

@WebServlet(name = "DatabaseCreationServlet", value = "/creatDB")
public class DatabaseCreationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = new User("ff","ff","ff");
        entityManager.getTransaction().begin();

        entityManager.persist(user); // Saves the entity and returns the identifier

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
