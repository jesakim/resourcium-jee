package com.resourcium1.controllers;

import com.resourcium1.dao.ReservationDAO;
import com.resourcium1.models.Reservation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ReservationController", value = "/reservations")
public class ReservationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);

        response.getWriter().write("Request processed successfully");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date startDate = null;
        Date endDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("startDate"));
            endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("endDate"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int equipmentId = Integer.parseInt(request.getParameter("equipmentId"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));

        Reservation reservation = new Reservation();
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setEquipmentId(equipmentId);
        reservation.setEmployeeId(employeeId);
        ReservationDAO.create(reservation);
        response.setStatus(HttpServletResponse.SC_CREATED);

    }
}
