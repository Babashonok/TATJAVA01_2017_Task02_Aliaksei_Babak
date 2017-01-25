package com.epam.task2.shop;

import com.epam.task2.equipment.SportEquipment;

import java.util.LinkedList;

/**
 * RentUnit - storage of rent equipment
 */
public class RentUnit {

    private LinkedList<SportEquipment> units = new LinkedList<>();

    public LinkedList<SportEquipment> getUnits() {
        return units;
    }
}
