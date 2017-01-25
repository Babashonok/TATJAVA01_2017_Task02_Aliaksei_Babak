package com.epam.task2.report;

import com.epam.task2.conversation.MessageStorage;
import com.epam.task2.equipment.SportEquipment;
import com.epam.task2.shop.Shop;
import java.util.*;

/**
 * Reportable Implement
 * Work with equipment in the shop storage
 */
public class AvailableUnitReport implements Reportable{

    @Override
    public void printReport(Object unit) {
        Shop shop = (Shop) unit;
        Set mapSet = shop.getListOfEquipment().entrySet();
        Iterator mapIterator = mapSet.iterator();
        MessageStorage.printReportHeader();
        while (mapIterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) mapIterator.next();
            SportEquipment equipment = (SportEquipment) mapEntry.getKey();
            Integer value = (Integer) mapEntry.getValue();
            System.out.println(new StringBuilder(equipment.getCategory()).append("       ")
                    .append(equipment.getTitle()).append("      ").append(value));
        }
    }
}
