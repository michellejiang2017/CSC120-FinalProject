import java.util.ArrayList;
import java.util.Map;

public class Store {
    protected String name;
    protected Map<String, Double> stock;   // name and price of item in stock all stock needs to be lowercase no whitespace
    //protected ArrayList<String> stock;  not sure what this is...
    protected int capacity;      // capacity of items? number of types of items    
    protected ArrayList<String> location; 

    public Store(String name, int capacity, String wing, String floor) {
        this.name = name;
        this.capacity = capacity;
        this.location = new ArrayList<String>();
        this.location.add(wing); 
        this.location.add(floor); 
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Double> getStock() { 
        return this.stock; // back-end use
    }

    public void enter(User user) {
       
    }

    public void exit(User user) {
        
    }

    public void browse(User user) {
       
    }

    public void buy(User user, String itemName) {
       
    }

    public void restock(String itemName, int amount) {
       
    }

    public void addItem(String itemName, double price, int amount) {
       
    }

    /**
     * Prints inventory nicely (used in Employee class)
     */
    public void printInventory() { 
        // front-end use
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