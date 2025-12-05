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
        shoppingList.add(item);
        System.out.println(item + " has been added to your shopping list.");
    }

    public void removeFromShoppingList(String item) {
        if (shoppingList.remove(item)) {
            System.out.println(item + " was removed from your shopping list.");
        } else {
            throw new RuntimeException("It is not in your shopping list.");
        }
    }

    public void viewShoppingList() {
        for (String item : shoppingList) {
                System.out.println(item);
            }
    }

    public void enterTheMall() {
        System.out.println("You entered the mall.");
        hunger += 1;
    }

    public void leaveTheMall() { 
        System.out.println("You left the mall.");
    }

    public void shop(double price) { 
         if (price > money) {
            System.out.println("You do not have enough money for this purchase.");
            return;
        }
        money -= price;
        hunger += 1; 
        System.out.println("You spent $" + price + ", and your remaining money is $" + money);
    }
    
    public void eat(Food food) { 
        food.dine(this.hunger, this.money);
        this.hunger = 0; 

    }

    public void play(String game) { 
        System.out.println("You played in the play zone.");
        hunger += 1; 
    }
}  