package com.epam.task2.requests;

import com.epam.task2.client.Client;
import com.epam.task2.equipment.SportEquipment;
import com.epam.task2.shop.Manager;
import com.epam.task2.shop.RentUnit;
import com.epam.task2.shop.Shop;

/**
 * Defines behavior for any request class
 */
public interface Requestable {
    /**
     * get unique word that defines request
     * @return word to execute request from the console
     */
    String getRequestCommandWord();

    /**
     * perform any request, according to it command word
     * if user input wrong request, re-ask for input
     *
     * @param client actor, who inputs requests
     * @param manager actor, who commits interaction between user requests and shop with rentUnit
     * @param shop available equipment storage
     * @param rentUnit rent equipment storage
     */
    void performRequest(Client client, Manager manager, Shop shop, RentUnit rentUnit);
}
