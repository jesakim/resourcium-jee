package com.resourcium1.dao;

import com.resourcium1.models.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ReservationDAO {
    public static Reservation find(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Reservation reservation = entityManager.find(Reservation.class, id);
        entityManager.close();
        entityManagerFactory.close();
        return reservation;
    }

    public List<Reservation> updateReservations() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Reservation> reservations = entityManager.createQuery("Select r from Reservation r join Equipment e on r.equipmentId = e.id where r.endDate > current_date AND e.type = 'Jetable'", Reservation.class).getResultList();
        entityManager.getTransaction().begin();

        for (Reservation reservation : reservations) {
            reservation.setEndDate(new java.sql.Date(System.currentTimeMillis() + reservation.getEquipment().getName().length() * 24 * 60 * 60 * 1000));
            entityManager.persist(reservation);
        }


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return reservations;
    }

    public static void create(Reservation reservation) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(reservation);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void update(Reservation reservation) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(reservation);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void deleteAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Reservation").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
