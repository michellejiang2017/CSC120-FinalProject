import java.util.ArrayList;
/**
 * File name: User.java
 * Author: Selina Fang, Aris Benitez-Linarez, Michelle Jiang
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

    public void changeMoney(double delta) {
        this.money += delta;
    }

    public ArrayList<String> getShoppingList() {
        return shoppingList;
    }

    public void changeHunger(int delta) {
        this.hunger += delta;
        System.out.println("Your hunger is now " + this.hunger + ".");
    }

    public boolean testHunger() {
        return this.hunger >= 5;
    }

    /**
     * Add an item to the shopping list
     * @param item the name of the item that the user wants to add to their shopping list
     * need to add inventory check!! --> check mall inventory 
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
            if (this.shoppingList.get(i).equalsIgnoreCase(item)) {
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
     * Enter the mall
     */
    public void enterTheMall() {
        System.out.println("You entered the mall.");
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
        money -= price;
        System.out.println("You spent $" + price + ", and your remaining money is $" + money);
    }
    
    /**
     * add the user's hunger
     */
    public void addHunger() {
        this.hunger += 1;
    }

    public void eat(Food food) { 
        if (food == null) return;
        food.dine(this);

    }

    public void play(String game) { 
        System.out.println("You played in the play zone.");
        hunger += 1; 
    }
}  