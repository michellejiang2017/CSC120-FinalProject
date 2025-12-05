import java.util.HashMap;
import java.util.Map;

public class Store {
    protected String name;
    protected Map<String, Double> items;  

    public Store(String name) {
        this.name = name;
        this.items = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    /** 
     * Check the shoppinglist
     */
    public boolean checkList(String item, User user) {
        return user.getShoppingList().contains(item.toLowerCase());
    }

     /** 
     * Check whether the item exists in the store
     */
    public boolean checkStock(String item) {
        return items.containsKey(item.toLowerCase());
    }

    /** 
     * Add item with price
     */
    public void addItem(String itemName, double price) {
        items.put(itemName, price);
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
        for (String item : items.keySet()) {
            System.out.println(item + ": $" + items.get(item));
        }
    }

    /** 
     * User buys an item and reduce user's money
     */
    public void buy(User user, String itemName) {
        if (!items.containsKey(itemName)) {
            throw new RuntimeException("Store does not sell this product.");
        }
        double price = items.get(itemName);
        if (user.getMoney() < price) {
            throw new RuntimeException("Not enough money to buy the item.");
        }
        user.spendMoney(price);
        System.out.println("You bought " + itemName + " for $" + price);
    }

    public void exit(User user) {
        System.out.println("You left this store.");
    }

    /** 
     * Compare shopping list with store inventory so that the user can automatically buy stuff  
     */
    public void buyFromShoppingList(User user) {
        for (String need : user.getShoppingList()) {
            if (items.containsKey(need)) {
                System.out.println("Found " + need + " in store, and we are buying");
                buy(user, need);
            } else {
                System.out.println("Store does not have" + need);
            }
        }
    }
}