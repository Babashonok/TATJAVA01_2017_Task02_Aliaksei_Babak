package com.epam.task2.file;

import com.epam.task2.equipment.SportEquipment;


import java.io.File;
import java.util.LinkedList;

/**
 * Interface for any possible file handler ( as XML , JSON, HTML etc.)
 * that defines behavior of taking information from the file
 */
public interface FileHandler {

    /**
     *
     * @param file with information about equipment in the shop
     * @return list of equipment from file
     * @throws Exception - FileNotFound
     */
    LinkedList<SportEquipment> sendListOfEquipment(File file) throws Exception;

    /**
     * execute steps to get access to information in the file
     * @param file with information about equipment in the shop
     * @return last step before read information from the file
     * @throws Exception - FileNotFound
     */
    Object getAccessToTheFile(File file) throws Exception;

}
