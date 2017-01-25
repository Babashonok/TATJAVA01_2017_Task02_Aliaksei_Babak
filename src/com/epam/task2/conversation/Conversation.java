package com.epam.task2.conversation;

import com.epam.task2.client.Client;
import com.epam.task2.requests.*;
import com.epam.task2.shop.Manager;
import com.epam.task2.shop.RentUnit;
import com.epam.task2.shop.Shop;

import java.util.InputMismatchException;

/**
 * Emulates conversation between client and manager
 */
public class Conversation {
    /**
     * create list of requests with common interface Requestable
     * @return list
     */
    private static ListOfRequests createListOfRequests() {
        return new ListOfRequests().add(new RentEquipRequest())
                .add(new ReleaseEquipRequest())
                .add(new ListOfRentEquipRequest())
                .add(new ListOfAvailableEquipRequest());
    }

    /**
     * Print Welcome message and list of commands
     * Start request input
     * @param client actor, who inputs requests
     * @param manager actor, who commits interaction between user requests and shop with rentUnit
     * @param shop available equipment storage
     * @param rentUnit rent equipment storage
     */
    public static void startConversation(Client client, Manager manager, Shop shop, RentUnit rentUnit) {
        ListOfRequests listOfRequests = createListOfRequests();
        MessageStorage.printWelcomeMessage(client.getName());
        realTimeRequesting(listOfRequests, client, manager, shop, rentUnit);
        MessageStorage.printEndMessage();

    }

    /**
     * Loop method, that handles and performs user requests
     * wait "exit" , to end this loop
     * @param listOfRequests available user requests
     * @param client actor, who inputs requests
     * @param manager actor, who commits interaction between user requests and shop with rentUnit
     * @param shop available equipment storage
     * @param rentUnit rent equipment storage
     */
    private static void realTimeRequesting(ListOfRequests listOfRequests, Client client, Manager manager, Shop shop, RentUnit rentUnit) {
        MessageStorage.askForCommandInput();
        String tempCommand = client.inputCommand();
        if (!tempCommand.equalsIgnoreCase("exit")) {
            try {
                listOfRequests.performRequest(tempCommand, client, manager, shop, rentUnit);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } finally {
                realTimeRequesting(listOfRequests, client, manager, shop, rentUnit);
            }
        }
    }
}


