package com.epam.task2.requests;

import com.epam.task2.client.Client;
import com.epam.task2.conversation.MessageStorage;
import com.epam.task2.equipment.SportEquipment;
import com.epam.task2.shop.Manager;
import com.epam.task2.shop.RentUnit;
import com.epam.task2.shop.Shop;

/**
 * Requestable Implement
 * Performs after user input "rent"
 */
public class RentEquipRequest implements Requestable{
    /**
     * trigger, that used for changing user equipment quantity
     */
    int triggerNumber = 1;

    @Override
    public String getRequestCommandWord() {
        return "rent";
    }

    @Override
    public void performRequest(Client client, Manager manager, Shop shop, RentUnit rentUnit) {
        if(client.getRentUnitQuantity() == 3) {
            throw new RuntimeException("you have 3 rent items. Release something, if you to rent new equipment ");
        }
        SportEquipment rentEquipment = client.getEquipmentUnderOperation();
        manager.changeEquipmentQuantity(rentEquipment, shop , triggerNumber);
        manager.addEquipmentToTheRentList(rentEquipment, rentUnit);
        client.setRentUnitQuantity(triggerNumber);
        MessageStorage.printSuccessMessage();
    }
}
