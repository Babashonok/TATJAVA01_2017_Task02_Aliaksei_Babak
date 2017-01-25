package com.epam.task2;


import com.epam.task2.client.Client;
import com.epam.task2.conversation.Conversation;
import com.epam.task2.shop.Manager;
import com.epam.task2.shop.RentUnit;
import com.epam.task2.shop.Shop;
import java.io.File;

/**
 * program describing the subject area : sporting goods store rental
 * @author Aliaksei_Babak
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        File file = new File("Equipment.xml");
        Shop shop = new Shop();
        RentUnit rentUnit = new RentUnit();
        Manager manager = new Manager();
        Client client = new Client("TestName");


        try {
            manager.fillShopEquipmentList(file,shop);
            Conversation.startConversation(client, manager, shop, rentUnit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
