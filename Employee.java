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
                    //suggestItem(item);
                }
            } else {
                System.out.println(item + "is not in shopping list. Either add item to list or exit store. ('add item' or press ENTER)");
                String input = this.getInput(); 
                if (input == null) continue; 
                // spaghetti code...
                if (input == "add item") { 
                    System.out.println("What is the item you want to add?");
                    String userItem = this.getInput(); 
                    if (userItem == null) continue; 
                    user.addToShoppingList(userItem, this.store);
                }
                // give option to add item to list and if no then choose to exit store? 
            }
        } while (stillPlaying);
        System.out.println("Goodbye! ");
        store.exit(user);
    }

    /** 
    // * Given the desired item of the user, suggests the next item in the inventory -- OR suggests similar item
    // */
    //public void suggestItem(String item) { 
    // suggests item
    // give hint about where item might be --> ie suggests different store
    // adds item to shopping list!
    // if item not in stock, suggest store name? 
    // if item does not exist then say that the item doesnt exist 
    //}

    /**
     * Gets input from user & converts it to a string
     * @return string formatted user input                                                              
     */
    private String getInput() { 
        return scannerInput.nextLine().trim().toLowerCase();
    }
    
    public static void main(String[] args) {
        Store store = new Store("Walmart", 10, "East", "First");
        User user = new User("Michelle", 19, "female", 1000, false, 0);
        Employee employee = new Employee(store, user); 
        employee.greetCustomer();
        employee.mainConversation();
    }
}
