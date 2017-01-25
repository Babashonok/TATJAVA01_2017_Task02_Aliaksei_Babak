package com.epam.task2.report;

/**
 * Defines behavior for any report class
 */
public interface Reportable {
    /**
     * takes list of equipment from storage
     * and prints it to the console + edit it in appropriate way
     * @param unit list of equipment
     */
    void printReport(Object unit);
}
