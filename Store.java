import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * File name: Store.java
 * Author: Selina Fang
 * Description: 
 * Date: 2025-12-5
 */

public class Store {
    protected String name;
    protected Map<String, Double> items;  

    public Store(String name, Inventory1 inventory) {
        this.name = name;
        this.items = inventory.getInventory(name); // inventory for the first floor
    }

    public Store(String name, Inventory2 inventory) {
        this.name = name;
        this.items = inventory.getInventory(name); // inventory for the second floor
    }

    public Store(String name) {
        this.name = name;
        this.items = new HashMap<>();   // empty inventory
    }

    /**
     * Get the name of the store
     * @return the name of the store
     */
    public String getName() {
        return this.name;
    }

    /** 
     * Check the shoppinglist
     * @param item the item that the user want to check
     * @param user the name of the user
     */
    public boolean checkList(String item, User user) {
        return user.getShoppingList().contains(item.toLowerCase());
    }

     /** 
     * Check whether the item exists in the store
     * @param item the item that the user want to check whether existing in this store
     */
    public boolean checkStock(String item) {
        return items.containsKey(item.toLowerCase());
    }

    /** 
     * Add item with price
     * @param item the name of the item that we want to add to the store
     * @param price the price of the item that we want to add to the store
     */
    public void addItem(String item, double price) {
        items.put(item, price);
    }

    /** 
     * Enter store
     */
    public void enter(User user) {
        System.out.println(user.getName() + " entered " + name);
    }

    /** 
     * Print inventory of the store 
     */
    public void printInventory() {
        System.out.println("The inventory of this store:");
        ArrayList<String> keys = new ArrayList<>(items.keySet());
        for (int i = 0; i < keys.size(); i++) {
            String name = keys.get(i);       
            double price = items.get(name );  
            System.out.println(name  + ": $" + price);
        }
    }

    /** 
     * User buys an item and reduce user's money
     * @param item the item that the user want to buy
     * @param user the name of the user
     */
    public void buy(User user, String item) {
        if (!items.containsKey(item)) {
            throw new RuntimeException("This store does not sell this product.");
        }
        double price = items.get(item);
        if (user.getMoney() < price) {
            throw new RuntimeException("You do not have enough money to buy the item.");
        }
        user.spendMoney(price);
        user.removeFromShoppingList(item);
        System.out.println("You successfully bought " + item + " for $" + price + ". It has been removed from your shopping list.");
    }

    /** 
     * Exit store
     */
    public void exit(User user) {
        System.out.println("You left this store.");
    }

    /** 
     * Compare shopping list with store inventory so that the user can automatically buy stuff  
     * @param user the name of the user
     * @throw RuntimeException if nothing in the shopping list is found in this store.
     */
    public void buyFromShoppingList(User user) {
        ArrayList<String> list = user.getShoppingList();
        for (int i = 0; i < list.size(); i++) {
            String need = list.get(i);
            if (items.containsKey(need)) {
                System.out.println("Found " + need + " in store, and we are buying it.");
                buy(user, need);
            } 
            else {
                throw new RuntimeException("Store does not have the" + need);
            }
        }
    }
}