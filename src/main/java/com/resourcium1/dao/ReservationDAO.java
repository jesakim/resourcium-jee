package com.resourcium1.dao;

import com.resourcium1.models.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ReservationDAO {
    public List<Reservation> updateReservation() {
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
}
