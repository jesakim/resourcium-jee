package com.resourcium1.dao;

import com.resourcium1.models.Reservation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationDAOTest {


    @Test
    void create() {
        Reservation reservation = new Reservation();
        reservation.setEmployeeId(1);
        reservation.setEquipmentId(1);
        reservation.setStartDate(new java.sql.Date(System.currentTimeMillis()));
        reservation.setEndDate(new java.sql.Date(System.currentTimeMillis() + 1000000));
        assertEquals(reservation.getId(), 0 );
        ReservationDAO.create(reservation);
        assertNotNull(reservation.getId());
        assertNotNull(ReservationDAO.find(reservation.getId()));
    }

    @Test
    void update() {
        Reservation reservation = new Reservation();
        reservation.setEmployeeId(1);
        reservation.setEquipmentId(1);
        reservation.setStartDate(new java.sql.Date(System.currentTimeMillis()));
        reservation.setEndDate(new java.sql.Date(System.currentTimeMillis() + 1000000));
        assertEquals(reservation.getId(), 0 );
        ReservationDAO.create(reservation);
        assertTrue(reservation.getId()!=0);
        reservation.setEmployeeId(2);
        ReservationDAO.update(reservation);
        assertEquals(reservation.getEmployeeId(), 2);

    }


    @AfterEach
    void tearDown() {
        ReservationDAO.deleteAll();
    }
}
