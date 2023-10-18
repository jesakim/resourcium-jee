package com.resourcium1.dao;

import com.resourcium1.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDao {

    public static void save(User user){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(user); // Saves the entity and returns the identifier

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static boolean check(String userName, String password){
        try {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        User user = (User) entityManager.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName)
                .getSingleResult();


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println(user);

        return user.getPassword().equals(password);
        }catch (Exception e){
            System.out.println("User with username " + userName + " not found.");
            return false;
        }
    }
}
