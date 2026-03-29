package rvt.online_shop;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart{

    Map<String, Integer> ShoppingCart = new HashMap<>();
    int total = 0;
    public void add(String product, int price){
        ShoppingCart.put(product, price);
        total += price;
    }

    public int price(){
        return total;
    }
}