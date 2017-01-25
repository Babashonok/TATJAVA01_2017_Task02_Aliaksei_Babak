package com.epam.task2.client;

import com.epam.task2.equipment.SportEquipment;

import java.util.Scanner;

/**
 * Describes user behavior
 */
public class Client {

    private String name;

    private int rentUnitQuantity;

    {
        this.rentUnitQuantity = 0;
    }
    public Client(String name) {
        this.name = name;
    }

    /**
     * Print category and title to determine equipment under operation
     * @return equipment to rent or release
     */
    public SportEquipment getEquipmentUnderOperation() {
        System.out.println("print category");
        String category = inputCommand();
        System.out.println("print title");
        return new SportEquipment(category, inputCommand());
    }

    public String inputCommand() {
        return new Scanner(System.in).nextLine();
    }

    public int getRentUnitQuantity() {
        return rentUnitQuantity;
    }

    /**
     * Change user equipment quantity
     * @param rentUnitQuantity ( 1 - if user rent an equipment,
     *                           -1 - if release something)
     */
    public void setRentUnitQuantity(int rentUnitQuantity) {
        this.rentUnitQuantity += rentUnitQuantity;
    }

    public String getName() {
        return name;
    }
}
