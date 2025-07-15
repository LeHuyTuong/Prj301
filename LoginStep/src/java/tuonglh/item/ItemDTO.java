/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.registration;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author USER
 */
public class ItemDTO implements Serializable{
    private String itemID;
    private double price;
    private String name;
    private Timestamp dateTime;
    public ItemDTO() {
    }

    public ItemDTO(String itemID, double price, String name, Timestamp dateTime) {
        this.itemID = itemID;
        this.price = price;
        this.name = name;
        this.dateTime = dateTime;
    }

    /**
     * @return the itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dateTime
     */
    public Timestamp getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

   
    
    
}
