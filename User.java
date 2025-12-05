import java.util.ArrayList;
import java.util.Scanner;

/**
 * File name: User.java
 * Author: Selina Fang
 * Description: 
 * Date: 2025-12-5
 */

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

    /**
     * Add an item to the shopping list
     * @param item the name of the item that the user wants to add to their shopping list
     */
    public void addToShoppingList(String item) {
        shoppingList.add(item);
        System.out.println(item + " has been added to your shopping list.");
    }

    /**
     * Remove an item to the shopping list
     * @param item the name of the item that the user wants to remove from their shopping list
     */
    public void removeFromShoppingList(String item) {
        if (shoppingList.remove(item)) {
            System.out.println(item + " was removed from your shopping list.");
        } else {
            throw new RuntimeException("It is not in your shopping list.");
        }
    }

    /**
     * Print the shopping list
     */
    public void viewShoppingList() {
        System.out.println("Shopping List:");
        for (int i = 0; i < shoppingList.size(); i++) {
            String item = shoppingList.get(i);
            System.out.println(item);
        }
    }

    /**
     * Enter the mall
     */
    public void enterTheMall() {
        System.out.println("You entered the mall.");
        hunger += 1;
    }

    /**
     * leave the mall
     * @throw RuntimeException if the uer did not buy all the stuff on the shopping list or they are too hungry
     */
    public void leaveTheMall() { 
        System.out.println("You left the mall.");
        if (shoppingList.isEmpty() || hunger <= 5) {
            System.out.println("You won!!");
        } else{
            throw new RuntimeException("You failed the game!!");
        }
    }

    /**
     * shop
     * @throw RuntimeException if the user did not have enough money
     * @param price the price of the item
     */
    public void shop(double price) { 
         if (price > money) {
            throw new RuntimeException("You do not have enough money for this purchase.");
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