package com.epam.task2.requests;

import com.epam.task2.client.Client;
import com.epam.task2.shop.Manager;
import com.epam.task2.shop.RentUnit;
import com.epam.task2.shop.Shop;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Storage of all Request classes object
 */
public class ListOfRequests {
    private ArrayList<Requestable> requestList = new ArrayList<>();

    /**
     * add new Object with Requestable implement to this list
     * @param request object that implement Requestable
     * @return link to this list
     */
    public ListOfRequests add(Requestable request) {
        requestList.add(request);
        return this;
    }

    /**
     * compare input from user and command words of Requestable classes
     * perform request of equal command word
     * @param commandWord user input
     * @param client actor, who inputs requests
     * @param manager actor, who commits interaction between user requests and shop with rentUnit
     * @param shop available equipment storage
     * @param rentUnit rent equipment storage
     */
    public void performRequest(String commandWord, Client client, Manager manager, Shop shop , RentUnit rentUnit) {
        boolean rightCommandInput = false;
        for (Requestable requestable : requestList) {
            if (commandWord.replaceAll(" ","").equalsIgnoreCase(requestable.getRequestCommandWord())) {
                requestable.performRequest(client, manager, shop, rentUnit);
                rightCommandInput = true;
            }
        }
        if (!rightCommandInput) {
            throw new InputMismatchException(commandWord + " is not recognized as an internal or external command");
        }
    }


}
