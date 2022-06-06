package Shop;

import Juice.Juice;
import Customer.Customer;
import java.util.Scanner;

public class Shop {

    public static void displayAllJuices(Juice[] allJuices) {
        int i=1;
        for (Juice j : allJuices) {
            System.out.println(i+".Juice Name : " + j.getName());
            System.out.println("Quantity : " + j.getQuantity());
            System.out.println("Price : " + j.getPrice());
            System.out.println("");
            i++;
        }
    }
    public static void menu(){
        System.out.print("\n===========Juice Shop===========\n");
        System.out.print("1. Create Account\n");
        System.out.print("2. Log in\n");
        System.out.print("3. Exit\n");
    }

    public static void main(String[] args) {
        Juice[] allJuices = new Juice[5];
        Customer[] allCustomers = new Customer[3];
        boolean LoggedIn = false;
        int CustomerIndex = -1;
        String user;
        String pass;
        int choice, i=3, p=0;
        int JuiceChoice;
        Scanner scan = new Scanner(System.in);
        Scanner scanSTR = new Scanner(System.in);
    
        allJuices[0] = new Juice("Cola", 4, 15);
        allJuices[1] = new Juice("Red Wine", 3, 12);
        allJuices[2] = new Juice("Lush Ice", 1, 9);
        allJuices[3] = new Juice("Blue Berry", 1, 27);
        allJuices[4] = new Juice("Momo Peach", 5, 22);


        menu();
        System.out.println("Enter your choice : ");
        choice = scan.nextInt();
        scan.nextLine();
        
        
        while(choice != 3)
        {
            if(choice == 1)
            {
                allCustomers[0] = new Customer("Ammar", "123");
                allCustomers[1] = new Customer("Ali", "123");
                allCustomers[2] = new Customer("mike", "123");
                
                for(int j=0; j<3; j++)
                {
                System.out.print("==========Account #"+(j+1)+"==========\n");
                System.out.println("Username : "+allCustomers[j].getName());
                System.out.print("Password : "+allCustomers[j].getPassword());
                
                System.out.println("\nACCOUNT CREATED!!!");
                }
                
            }
            else if(choice == 2)
            {
            while (!LoggedIn) {
                System.out.print("\n\nEnter Username : ");
                user = scanSTR.nextLine();
                System.out.print("Enter Password : ");
                pass = scanSTR.nextLine();

                for (int j = 0; j < i; j++) {
                    
                    if (allCustomers[j].checkDetails(user, pass)) {
                        LoggedIn = true;
                        CustomerIndex = j;
                        p=j;
                    }
                }

                if (LoggedIn) {
                    System.out.println("Login Successfull");
                } else {
                    System.out.println("Invalid Username Or Password !!");
                }

            }
            do{
            System.out.println("Welcome " + allCustomers[CustomerIndex].getName());
            System.out.println("Pick An Option : ");
            System.out.println("1.Display All Juices");
            System.out.println("2.Display Your Cart");
            System.out.println("3.Add to cart");
            System.out.println("4.Delete from cart");
            System.out.println("5.Purchase");
            System.out.println("6.Exit/Logout");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    displayAllJuices(allJuices);
                    break;
                case 2:
                    allCustomers[CustomerIndex].displayBoughtJuices();
                    break;
                case 3:
                    if (allCustomers[CustomerIndex].getTotalJuicesInCart() < 5) {
                        displayAllJuices(allJuices);
                        System.out.println("Pick A Juice : ");
                        JuiceChoice = scan.nextInt();
                        JuiceChoice--;
                        if (JuiceChoice < 5 && JuiceChoice >= 0) {
                            if (allJuices[JuiceChoice].getQuantity() != 0) {
                                allCustomers[CustomerIndex].BuyJuice(allJuices[JuiceChoice]);
                                allJuices[JuiceChoice].decreaseQuantity();
                            } else {
                                System.out.println("Juice Unavailable !");
                            }

                        } else {
                            System.out.println("Invalid Option");
                        }
                    } else {
                        System.out.println("Your Cart is full!");
                    }
                    break;
                case 4:
                    if (allCustomers[CustomerIndex].getTotalJuicesInCart() > 0) {
                        allCustomers[CustomerIndex].displayBoughtJuices();
                        System.out.println("Pick A Juice To Remove : ");
                        JuiceChoice = scan.nextInt();
                        JuiceChoice--;
                        if (JuiceChoice < allCustomers[CustomerIndex].getTotalJuicesInCart() && JuiceChoice >= 0) {

                            String bn = allCustomers[CustomerIndex].DeleteItemFromCart(JuiceChoice);

                            for (Juice j : allJuices) {
                                if (j.getName().equals(bn)) {
                                    j.increaseQuantity();
                                }
                            }
                        } else {
                            System.out.println("Invalid Option");
                        }
                    } else {
                        System.out.println("You Haven't bought any Juices!");
                    }
                    break;
                case 5:
                    int payChoice;
                    System.out.println("\nWould like to pay yes(1)/No(2)? ");
                    payChoice = scan.nextInt();
                    scan.nextLine();
                    System.out.println("\n==========Bill==========");
                    if(payChoice == 1)
                    {
                        System.out.println("Your Total is : " + allCustomers[p].getTotal()+ "$");
                    }
                    System.out.print("==========Bill==========\n");
                    break;

            }

        } while (choice != 6);
            }
            menu();
            System.out.println("Enter your choice : ");
            choice = scan.nextInt();
            scan.nextLine();
            CustomerIndex = -1;
            LoggedIn = false;
        }
       
        

    }

}
