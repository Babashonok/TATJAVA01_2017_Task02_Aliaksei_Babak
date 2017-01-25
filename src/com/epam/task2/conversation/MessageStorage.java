package com.epam.task2.conversation;

/**
 * Storage for different console messages
 */
public class MessageStorage {

    public static void printWelcomeMessage(String clientName) {
        System.out.println(new StringBuilder("Hello ").append(clientName ).append('\n')
                .append("We are welcome you in our Sport Shop. You can use the following commands:").append('\n')
                .append("1) available - for show the list of available equipment").append('\n')
                .append("2) rentList - for show the list of rent equipment").append('\n')
                .append("3) rent - to rent equipment from the shop").append('\n')
                .append("4) release - to release rent equipment back to the shop ").append('\n')
                .append("5) exit - to the the working session").append('\n')
                .append("Try to input correct name of the command.Good Luck!"));
    }

    public static void printEndMessage() {
        System.out.println("Thanks for using our shop!");
    }
    public static void askForCommandInput() {
        System.out.print("Input : ");
    }
    public static void printReportHeader() {
        System.out.println("Category  |  Title  |  Quantity");
    }

    public static void printSuccessMessage() {
        System.out.println("Request complete!");
    }

    public static void printReportHeaderWithoutQuantity() {
        System.out.println("Category  |  Title ");
    }
}
