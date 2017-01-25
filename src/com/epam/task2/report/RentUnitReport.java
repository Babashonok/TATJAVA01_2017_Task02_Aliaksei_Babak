package com.epam.task2.report;

import com.epam.task2.conversation.MessageStorage;
import com.epam.task2.equipment.SportEquipment;
import com.epam.task2.shop.RentUnit;

/**
 * Reportable Implement
 * Work with equipment in the rentUnit storage
 */
public class RentUnitReport implements Reportable {

    @Override
    public void printReport(Object unit) {
        MessageStorage.printReportHeaderWithoutQuantity();
        RentUnit rentUnit = (RentUnit) unit;
        for (SportEquipment equipment : rentUnit.getUnits()) {
            System.out.println(new StringBuilder(equipment.getCategory()).append("       ")
                    .append(equipment.getTitle()));
        }
    }
}
