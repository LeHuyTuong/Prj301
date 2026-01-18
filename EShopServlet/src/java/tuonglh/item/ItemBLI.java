/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tuonglh.item;

import java.util.List;

/**
 *
 * @author USER
 */
public interface ItemBLI {
    List<Item> searchItems(String searchName);
    Item getNameByID(String searchName);
    boolean addNewItem(Item item);
}
