package com.resourcium1.dao;

import com.resourcium1.models.Equipment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentDAOTest {

    @Test
    void create() {
        Equipment equipment = new Equipment();
        equipment.setName("Test Equipment");
        equipment.setType("Test Type");
        assertEquals(equipment.getId(), 0 );
        EquipmentDAO.create(equipment);
        assertNotNull(equipment.getId());
        assertNotNull(EquipmentDAO.find(equipment.getId()));
    }

    @Test
    void update() {
        Equipment equipment = new Equipment();
        equipment.setName("Test Equipment");
        equipment.setType("Test Type");
        assertEquals(equipment.getId(), 0 );
        EquipmentDAO.create(equipment);
        assertNotNull(equipment.getId());
        equipment.setName("Updated Test Equipment");
        EquipmentDAO.update(equipment);
        assertEquals(equipment.getName(), "Updated Test Equipment");
    }

    @AfterEach
    void tearDown() {
        EquipmentDAO.deleteAll();
    }

}