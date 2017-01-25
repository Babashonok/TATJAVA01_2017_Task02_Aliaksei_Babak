package com.epam.task2.shop;

import com.epam.task2.equipment.SportEquipment;
import com.epam.task2.file.XMLFileHandler;

import java.io.File;
import java.util.*;

/**
 * layer between user requests and changes in the shop and rent unit
 */
public class Manager {
    /**
     * fill shop list using information from the file
     * @param file with information about equipment in the shop
     * @param shop storage of available equipment
     * @throws Exception -FileNotFound
     */
    public void fillShopEquipmentList(File file, Shop shop) throws Exception {
        XMLFileHandler fileHandler = new XMLFileHandler();
        shop.setEquipmentList(this.orderEquipment(fileHandler.sendListOfEquipment(file)));
    }

    /**
     * add equipment to the rent list after user print "rent" request
     * @param equipment equipment chosen by the user
     * @param rentUnit storage of rent equipment
     */
    public void addEquipmentToTheRentList(SportEquipment equipment, RentUnit rentUnit) {
        rentUnit.getUnits().add(equipment);
    }

    /**
     * change Quantity of equipment in the Shop
     * if number of available equip = 0 remove it from list
     *
     * @param equipment equipment chosen by the user
     * @param shop storage for available equipment
     * @param triggerNumber trigger, that used for changing user equipment quantity
     */
    public void changeEquipmentQuantity(SportEquipment equipment, Shop shop, int triggerNumber) {
        if (shop.getListOfEquipment().containsKey(equipment)) {
            shop.getListOfEquipment().put(equipment,shop.getListOfEquipment().get(equipment) - triggerNumber);
        } else if ( triggerNumber == -1) {
            shop.getListOfEquipment().put(equipment, -1 * triggerNumber);
        } else {
            throw new InputMismatchException("shop doesn't contain this item");
        }
        if (shop.getListOfEquipment().get(equipment) == 0) {
            shop.getListOfEquipment().remove(equipment);
        }

    }

    /**
     * remove equipment from the rent list after user print "release" request
     * @param equipment equipment chosen by the user
     * @param rentUnit storage of rent equipment
     */
    public void releaseEquipmentFromTheRentList(SportEquipment equipment, RentUnit rentUnit) {
        rentUnit.getUnits().remove(equipment);
    }

    /**
     * Transform list of equipment to new HashMap <SportEquipment, Integer>
     * @param listOfEquipment list taken from the file
     * @return list of available equipment, that will storage in the shop
     */
    private Map<SportEquipment, Integer> orderEquipment(LinkedList<SportEquipment> listOfEquipment) {

        Map<SportEquipment, Integer> goods = new HashMap<>();
        for (SportEquipment equipment : listOfEquipment) {
            if (!goods.containsKey(equipment)) {
                goods.put(equipment, 1);
            } else {
                goods.put(equipment,goods.get(equipment) + 1);
            }
        }
        return goods;
    }
}
