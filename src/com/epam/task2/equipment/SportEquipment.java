package com.epam.task2.equipment;
/**
 * Describes SportEquipment objects
 * Possible superclass for hierarchy of available equipment
 */
public class SportEquipment {

    private String category;
    private String title;

    public SportEquipment(String category, String title) {
        this.category = category;
        this.title = title;

    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Override method equals, that check link type and category + title equality
     * @param obj comparable object
     * @return is equal
     */
    @Override
    public boolean equals(Object obj) {
        SportEquipment sportEquipment = (SportEquipment) obj;
        return getClass() == obj.getClass() && !(!title.equals(sportEquipment.getTitle()) || !category.equals(sportEquipment.getCategory()));
    }

    /**
     * Override hashcode, that doesn't influence on method equals
     * @return 0 - similar hashcode for any object
     */
    @Override
    public int hashCode() {
        return 0;
    }
}
