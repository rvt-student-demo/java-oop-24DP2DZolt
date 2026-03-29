package rvt.online_shop; 

public class Item{
    String product;
    int qty;
    int unitPrice;
    public Item(String product, int qty, int unitPrice){
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int price(){
        return qty*unitPrice;
    }

    public void increaseQuantity(){
        qty += 1;
    }

    public String toString(){
        return product + ": " + qty;
    }
}