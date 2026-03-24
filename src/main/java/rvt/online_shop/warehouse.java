package rvt.online_shop;
import java.util.HashMap;
import java.util.Map;
public class warehouse {
    Map<String, Integer> products = new HashMap<>();

    public void warehouse(){
        
    }

    public void addProduct(String product, int price, int stock){
        products.put(product, price);
    }

    public int price(String product){
        return products.get(product);
    }

}

