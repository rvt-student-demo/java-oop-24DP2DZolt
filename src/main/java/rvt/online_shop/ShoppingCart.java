package rvt.online_shop;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart{

    Map<String, Item> ShoppingCart = new HashMap<>();
    int total = 0;
    public void add(String product, int price){
        Item item = new Item(product, 1, price);
        total += item.price();
        ShoppingCart.put(product, item);
    }

    public int price(){
        return total;
    }

    public void print(){
        
        for (Item product: ShoppingCart.values()) {
            System.out.println(product.toString());
        } 
    }
}