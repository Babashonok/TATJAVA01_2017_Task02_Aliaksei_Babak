package com.epam.task2.shop;

import com.epam.task2.equipment.SportEquipment;

import java.util.Map;

/**
 * Shop - storage of available equipment
 */
public class Shop {
    private Map<SportEquipment, Integer> equipmentList;

    public  Map<SportEquipment, Integer> getListOfEquipment() {
        return equipmentList;
    }
    public void setEquipmentList(Map<SportEquipment, Integer> equipmentList) {
        this.equipmentList = equipmentList;
    }
}
