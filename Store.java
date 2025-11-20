import java.util.List;
import java.util.Map;

public class Store {
    protected String name;
    protected Map<String, Double> items;   // all items & stock needs to be lowercase no whitespace
    protected Map<String, Integer> stock;  
    protected int capacity;             

    public Store(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
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

    }

    /**
     * Checks if item is in shopping list
     * @return true if item in list false otherwise
     */
    public boolean checkItem(String item) { 
        return true; 
    }

    /**
     * Checks if item is in stock
     * @return true if item in list false otherwise
     */
    public boolean checkStock(String item) {
        return true; 
    }
}