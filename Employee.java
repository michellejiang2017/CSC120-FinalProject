import java.util.Scanner;

/**
 * File name: Employee.java
 * Author Michelle Jiang 
 * Description: 
 * Date: 2025-11-20
 */


public class Employee {

    // Attributes 
    Store store; 
    User user; 
    Scanner scannerInput; 

    // Constructor
    public Employee(Store store, User user) {
        this.store = store; 
        this.user = user; 
        this.scannerInput = new Scanner(System.in); 
    }

    /**
     * Initial user greeting 
     */
    public void greetCustomer() { 
        System.out.println("Hello " + this.user.getName() + ", welcome to " + this.store.getName() + "! ");
    }

    /**
     * Asks user to buy items from inventory 
     */
    public void mainConversation() { 
        boolean stillPlaying = true; 
        do {
            System.out.println("What would you like to purchase from this store? (Type 'exit' to leave store)");
            String item = this.getInput(); 
            if (item == null) continue;
            if (item.equals("exit")) {
                stillPlaying = false;
                break; 
            }
            if (store.checkList(item, user)) { 
                if (store.checkStock(item)) { 
                    store.buy(user, item);
                    user.removeFromShoppingList(item);
                } else {
                    System.out.println(item + " is not in the store. Please find the item in another store! (press ENTER)");
                    suggestStore(item);
                }
            } else {
                System.out.println(item + "is not in shopping list. Either add item to list or exit store. ('add item' or press ENTER)");
                String input = this.getInput(); 
                if (input == null) continue; 
                if (input == "add item") { 
                    System.out.println("What is the item you want to add?");
                    String userItem = this.getInput(); 
                    if (userItem == null) continue; 
                    user.addToShoppingList(userItem, this.store);
                }
            }
        } while (stillPlaying);
        System.out.println("Goodbye! ");
        store.exit(user);
    }

    /**
     * Gets input from user & converts it to a string
     * @return string formatted user input                                                              
     */
    private String getInput() { 
        return scannerInput.nextLine().trim().toLowerCase();
    }

    /**
     * Suggests another store in the mall that is likely to carry the given item.
     * This uses simple keyword matching against a small set of known stores in the mall.
     * If no good match is found, it prints a generic suggestion to check other wings.
     */
    public void suggestStore(String item) {
        if (item == null || item.isEmpty()) {
            System.out.println("No item given to suggest for.");
            return;
        }
        String it = item.toLowerCase();
        String suggestion = null;

        // simple keyword-based suggestions
        if (it.contains("phone") || it.contains("charger") || it.contains("electronics") || it.contains("tv") || it.contains("laptop")) {
            suggestion = "Best Buy";
        } else if (it.contains("book") || it.contains("novel") || it.contains("magazine")) {
            suggestion = "Barnes & Noble";
        } else if (it.contains("furniture") || it.contains("sofa") || it.contains("bed") || it.contains("table")) {
            suggestion = "Ikea";
        } else if (it.contains("food") || it.contains("burger") || it.contains("fries") || it.contains("meal") || it.contains("pizza") || it.contains("tea") || it.contains("coffee")) {
            suggestion = "Try a food vendor (e.g., McDonald's, Starbucks, Insomnia Cookies, NiceTea)";
        } else if (it.contains("makeup") || it.contains("perfume") || it.contains("cosmetic") || it.contains("skincare")) {
            suggestion = "Sephora";
        } else if (it.contains("clothes") || it.contains("shirt") || it.contains("dress") || it.contains("jacket") || it.contains("pants")) {
            suggestion = "Marshalls, TJ Maxx, or Burlington";
        } else if (it.contains("toy") || it.contains("game") || it.contains("console")) {
            suggestion = "GameStop or Best Buy";
        } else if (it.contains("cookies") || it.contains("dessert") || it.contains("sweets")) {
            suggestion = "Insomnia Cookies";
        }

        if (suggestion != null) {
            System.out.println("Suggestion: Try '" + suggestion + "' to find '" + item + "'.");
        } else {
            System.out.println("I couldn't find a specific store for '" + item + "'. Try checking other wings or browsing the mall map.");
        }
    }
    
    public static void main(String[] args) {
        Store store = new Store("Walmart", "East", "First");
        store.addItem("laptop", 999.99);
        store.addItem("headphones", 199.99);
        store.addItem("coffee", 4.99);
        store.addItem("tshirt", 10);
        store.addItem("jeans", 20);
        store.addItem("tea", 5);
        store.addItem("milk", 5);
        User user = new User("Michelle", 19, "female", 1000, 0);
        Employee employee = new Employee(store, user); 
        employee.greetCustomer();
        employee.mainConversation();
    }
}
