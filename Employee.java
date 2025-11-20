/**
 * File name: Employee.java
 * Author Michelle Jiang 
 * Description: 
 * Date: 2025-11-20
 */

import java.util.Scanner; 

public class Employee {

    // Attributes 
    Store store; 
    User user; 

    // Constructor
    public Employee(Store store, User user) {
        this.store = store; 
        this.user = user; 
    }

    /**
     * Initial user greeting 
     */
    public void greetCustomer() { 
        System.out.println("Hello" + this.user + ", welcome to " + this.store + "! ");
    }

    /**
     * Asks user to buy items from inventory 
     */
    public void mainConversation() { 
        String item = ""; 
        while (item != "exit") {
            System.out.println("What would you like to purchase from this store? (Type 'exit' to leave store)");
            item = user.getInput(); 
            if (store.checkItem(item)) { 
                if (store.checkStock(item)) { 
                    store.buy(user, item);
                } else {
                    suggestItem(item);
                }
            } else {
                System.out.println(item + "is not in shopping list. Either add item to list or exit store. ");
                // give option to add item to list and if no then choose to exit store? 
            }
        } 
        System.out.println("Goodbye! ");
        store.exit(user);
    }

    /** 
     * Given the desired item of the user, suggests the next item in the inventory -- OR suggests similar item
     */
    public void suggestItem(String item) { 
        // suggests item
        // give hint about where item might be --> ie suggests different store
        // adds item to shopping list!
    }

    public static void main(String[] args) {
        System.out.println("Hello, Employee!");
    }
}
