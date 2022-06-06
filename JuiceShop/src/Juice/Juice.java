package Juice;

public class Juice {
    String name;
    int price;
    int quantity;
    
    public Juice(){
        
    }
    public Juice(String n,int amnt, int p){
        name = n;
        price = p;
        quantity = amnt;
    }
    
    public String getName(){
        return name;
    }
    
    public int getPrice(){
        return price;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void increaseQuantity(){
        quantity++;
    }
    
    public void decreaseQuantity(){
        quantity--;
    }
}
