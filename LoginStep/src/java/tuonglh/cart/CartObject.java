/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author USER
 */
public class CartObject implements Serializable {

    private Map<String, Integer> items;

    public Map<String, Integer> getItems() {
        return items;
    }

    public void addItemToCart(String id) {
        //1. check items's id is existed 
        if (id == null) {
            return;
        }
        if (id.trim().isEmpty()) {
            return;
        }

        //2 when item is existed
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        //3 when items has existed checking existed id
        int quantity = 1;
        if (this.items.containsKey(id)) {
            quantity = this.items.get(id) + 1;
        }

        //4 update items
        this.items.put(id, quantity);

    }

    public void removeItemFromCart(String id) {
        //1 check exist items
        if (this.items == null) {
            return;
        }
        //when items has existed 
        if (this.items.containsKey(id)) {
            this.items.remove(id);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }

    }

}
