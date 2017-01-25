package com.epam.task2.requests;

import com.epam.task2.client.Client;
import com.epam.task2.report.RentUnitReport;
import com.epam.task2.shop.Manager;
import com.epam.task2.shop.RentUnit;
import com.epam.task2.shop.Shop;

/**
 * Requestable Implement
 * Performs after user input "rentList"
 */
public class ListOfRentEquipRequest implements Requestable {
    @Override
    public String getRequestCommandWord() {
        return "rentList";
    }

    @Override
    public void performRequest(Client client, Manager manager, Shop shop, RentUnit rentUnit) {
        RentUnitReport unitReport = new RentUnitReport();
        unitReport.printReport(rentUnit);
    }
}
