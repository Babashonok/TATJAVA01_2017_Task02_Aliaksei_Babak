package com.epam.task2.file;

import com.epam.task2.equipment.SportEquipment;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;

/**
 * FileHandler Implement
 * Allows program taking information from the .xml file with correct node names
 */
public class XMLFileHandler implements FileHandler{

    @Override
    public LinkedList<SportEquipment> sendListOfEquipment(File file) throws Exception {
        LinkedList <SportEquipment> listOfEquipment = new LinkedList<>();
        NodeList nodeList = this.getAccessToTheFile(file);
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            NamedNodeMap attrs = nodeList.item(i).getAttributes();
            listOfEquipment.add(new SportEquipment(attrs.getNamedItem("category").getNodeValue(),
                                                   attrs.getNamedItem("title").getNodeValue()));
        }
        return listOfEquipment;
    }
    @Override
    public NodeList getAccessToTheFile(File file) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        return document.getElementsByTagName("equipment");
    }

}
