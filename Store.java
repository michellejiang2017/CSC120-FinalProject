import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    protected String name;
    protected HashMap<String, Double> stock;   // name and price of item in stock all stock needs to be lowercase no whitespace 
    protected ArrayList<String> location; 

    public Store(String name, String wing, String floor) {
        this.name = name;
        this.location = new ArrayList<String>();
        this.location.add(wing); 
        this.location.add(floor); 
        this.stock = new HashMap<String, Double>();
    }

    public String getName() {
        return this.name;
    }

    public HashMap<String, Double> getStock() { 
        return this.stock; // back-end use
    }

    public void enter(User user) {
        if (user == null) {
            throw new RuntimeException("No user provided to enter the store.");
        }
        System.out.println(user.getName() + " entered " + this.name + ". Welcome!");
    }

    public void exit(User user) {
        if (user == null) {
            throw new RuntimeException("No user provided to exit the store.");
        }
        System.out.println(user.getName() + " has left " + this.name + ". Goodbye!");
    }

    public void browse(User user) {
        System.out.println("Browsing " + this.name + " inventory:");
        printInventory();
    }

    public void buy(User user, String itemName) {
       
    }

    /**
     * Adds item to store inventory
     * @param itemName the name of item
     * @param price the item's price 
     */
    public void addItem(String itemName, double price) {
        if (itemName == null || itemName.isEmpty()) {
            System.out.println("Invalid item name.");
            return;
        }
        this.stock.put(itemName.toLowerCase(), price);
        System.out.println("Added " + itemName + " to " + this.name + " at price $" + price + ".");
    }

    /**
     * Prints inventory nicely (used in Employee class)
     */
    public void printInventory() { 
        if (this.stock == null || this.stock.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }
        for (HashMap.Entry<String, Double> e : this.stock.entrySet()) {
            System.out.println("- " + e.getKey() + ": $" + e.getValue());
        }
    }

    /**
     * Checks if item is in shopping list
     * @return true if item in list false otherwise
     */
    public boolean checkList(String item, User user) { 
        if (user.getList().indexOf(item) != -1) {
            return true; 
        } else {
            return false; 
        }
    }

    /**
     * Checks if item is in stock
     * @return true if item in list false otherwise
     */
    public boolean checkStock(String item) {
        if (this.getStock().containsKey(item)) {
            return true; 
        } else {
            return false; 
        }
    }
}