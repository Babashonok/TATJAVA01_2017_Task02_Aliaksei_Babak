package com.epam.task2.requests;

import com.epam.task2.client.Client;
import com.epam.task2.conversation.MessageStorage;
import com.epam.task2.equipment.SportEquipment;
import com.epam.task2.shop.Manager;
import com.epam.task2.shop.RentUnit;
import com.epam.task2.shop.Shop;

/**
 * Requestable Implement
 * Performs after user input "release"
 */
public class ReleaseEquipRequest implements Requestable {
    /**
     * trigger, that used for changing user equipment quantity
     */
    int triggerNumber = -1;
    @Override
    public String getRequestCommandWord() {
        return "release";
    }

    @Override
    public void performRequest(Client client, Manager manager, Shop shop, RentUnit rentUnit) {
        if(client.getRentUnitQuantity() == 0) {
            throw new RuntimeException("You have 0 rent items.You cant release anything");
        }
        SportEquipment rentEquipment = client.getEquipmentUnderOperation();
        manager.changeEquipmentQuantity(rentEquipment, shop, triggerNumber);
        manager.releaseEquipmentFromTheRentList(rentEquipment, rentUnit);
        client.setRentUnitQuantity(triggerNumber);
        MessageStorage.printSuccessMessage();

    }
}
