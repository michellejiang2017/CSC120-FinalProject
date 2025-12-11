import java.util.ArrayList;
/**
 * File name: User.java
 * Author: Selina Fang, Aris Benitez-Linarez, Michelle Jiang
 * Description: This class represents a user who shops in the mall.
 * Date: 2025-12-5
 */

public class User {
    private String name;
    private double money;
    private ArrayList<String> shoppingList; 
    private int hunger; // starts at zero and increases with every exit. 

    /**
     * Constructor for User. use scanner to get input for the constructor
     * @param name the name of the user
     * @param money the amount of money the user has
     */
    public User(String name, double money) {
        this.name = name;
        this.money = money;
        this.shoppingList = new ArrayList<>();
        this.hunger = 0; 
    }

    /**
     * Get the name of the user
     * @return the name of the user
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the amount of money the user has
     * @return the amount of money the user has
     */
    public double getMoney() { 
        return money; 
    }


    /**
     * Get the shopping list
     * @return the shopping list
     */
    public ArrayList<String> getShoppingList() {
        return shoppingList;
    }

    /**
     * Change the hunger level
     * @param delta the amount to change the hunger level by
     */
    public void changeHunger(int delta) {
        this.hunger += delta;
        if (this.hunger < 0) {
            this.hunger = 0;
        }
        System.out.println("Your hunger is now " + this.hunger + ".");
    }

    /**
     * Test if the user is too hungry
     * @return whether the user is too hungry
     */
    public boolean testHunger() {
        return this.hunger >= 5;
    }

    /**
     * Get the hunger level
     * @return the hunger level
     */
    public int getHungerLevel() {
        return this.hunger;
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
     * Remove an item to the shopping list (note: user should be able to remove items from the shopping list even if they are not purchased)
     * @param item the name of the item that the user wants to remove from their shopping list
     */
    public void removeFromShoppingList(String item) {
        if (item == null) return;
        boolean removed = false;
        for (int i = 0; i < this.shoppingList.size(); i++) {
            if (this.shoppingList.get(i).equalsIgnoreCase(item.trim())) {
                this.shoppingList.remove(i);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Removed " + item + " from your shopping list.");
        } else {
            System.out.println(item + " was not found in your shopping list.");
        }
    }

    /**
     * Print the shopping list
     */
    public void viewShoppingList() {
        System.out.println("Your shopping list:");
        if (this.shoppingList == null || this.shoppingList.isEmpty()) {
            System.out.println(" - (empty)");
            return;
        }
        for (String s : this.shoppingList) {
            System.out.println(" - " + s);
        }
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
        if (price < 0) {
            System.out.println("Invalid price.");
            return;
        }
         if (price > money) {
            throw new RuntimeException("You do not have enough money for this purchase.");
        }
        this.money -= price;
        System.out.println("You spent $" + price + ", and your remaining money is $" + money);
    }
    
    /**
     * add the user's hunger
     */
    public void addHunger() {
        this.hunger += 1;
    }

    /**
     * eat food from a food store
     * @param food the food store
     */
    public void eat(Food food) { 
        if (food == null) return;
        this.changeHunger(food.getNourishment());
        System.out.println("You ate some food from " + food.getName() + ".");
    }
}  