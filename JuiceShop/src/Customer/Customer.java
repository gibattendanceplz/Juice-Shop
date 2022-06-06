package Customer;
import Juice.Juice;

public class Customer {
    String name;
    String password;
    int totalJuicesInCart, total=0;
    Juice[] BoughtJuices = new Juice[5];
    
    public Customer(String n,String pass){
       name = n;
       password = pass;
       totalJuicesInCart = 0;
       for(int i=0;i<5;i++){
           BoughtJuices[i] = new Juice();
       }
    }
    
    public boolean checkDetails(String username,String pass){
        if(name.equals(username) && password.equals(pass)){
            return true;
        }else{
            return false;
        }
    }
    
    public String getName(){
        return name;
    }
    public String getPassword()
    {
        return password;
    }
    
    public void displayBoughtJuices(){
        for(int i=0;i< totalJuicesInCart;i++){
        System.out.println("Juice Name : "+BoughtJuices[i].getName());
        System.out.println("");
        }
    }
    
    public void BuyJuice(Juice j){
        BoughtJuices[totalJuicesInCart] = j;
        total = total + BoughtJuices[totalJuicesInCart].getPrice();
        totalJuicesInCart++;
    }
    
    public String DeleteItemFromCart(int choice){
        String bn = BoughtJuices[choice].getName();
        for(int i=choice;i<totalJuicesInCart-1;i++){
            BoughtJuices[i] = BoughtJuices[i+1];
        }
        totalJuicesInCart--;
        return bn;
    }
    
    public int getTotalJuicesInCart(){
        return totalJuicesInCart;
    }
    
    public int getTotal()
    {
        return total;
    }
    
}
