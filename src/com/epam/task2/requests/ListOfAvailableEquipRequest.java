package com.epam.task2.requests;

import com.epam.task2.client.Client;
import com.epam.task2.report.AvailableUnitReport;
import com.epam.task2.shop.Manager;
import com.epam.task2.shop.RentUnit;
import com.epam.task2.shop.Shop;

/**
 * Requestable Implement
 * Performs after user input "available"
 */
public class ListOfAvailableEquipRequest implements Requestable {

    @Override
    public String getRequestCommandWord() {
        return "available";
    }

    @Override
    public void performRequest(Client client, Manager manager, Shop shop, RentUnit rentUnit) {
        AvailableUnitReport unitReport = new AvailableUnitReport();
        unitReport.printReport(shop);
    }
}
