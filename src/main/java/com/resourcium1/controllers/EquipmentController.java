package com.resourcium1.controllers;

import com.resourcium1.dao.EquipmentDAO;
import com.resourcium1.models.Equipment;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EquipmentController", value = "/equipments")
public class EquipmentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);

        // You can also provide a response message if needed
        response.getWriter().write("Request processed successfully");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        Equipment equipment = new Equipment();
        equipment.setName(name);
        equipment.setType(type);
        EquipmentDAO.create(equipment);
        response.setStatus(HttpServletResponse.SC_CREATED);

    }
}
