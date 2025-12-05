import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String name;
    private double money;
    private ArrayList<String> shoppingList; 
    private int hunger; // starts at zero and increases with every exit. 

    // use scanner to get input for the constructor
    public User(String name, int age, String gender, double money, int hunger) {
        this.name = name;
        this.money = money;
        this.shoppingList = new ArrayList<>();
        this.hunger = hunger; 
        System.out.println("I see you have $" + money + " to spend today.");
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() { 
        return money; 
    }

    public void spendMoney(double amount) {
        this.money -= amount;
    }

    public ArrayList<String> getShoppingList() {
        return shoppingList;
    }

    public void addToShoppingList(String item) {
    }

    public void removeFromShoppingList(String item) {
        
    }

    public void viewShoppingList() {
        
    }

    public void enterTheMall() {

    }

    public void leaveTheMall() { 

    }

    public void shop(double price) { 

    }


    public void eat(Food food) { 
        food.dine(this.hunger, this.money);
    }

    public void play(String game) { 

    }
}  