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
        //while (item != "exit") {
            System.out.println("What would you like to purchase from this store? (Type 'exit' to leave store)");
            item = this.getInput(); 
            if (store.checkItem(item)) { 
                if (store.checkStock(item)) { 
                    store.buy(user, item);
                    user.removeFromShoppingList(item);
                } else {
                    suggestItem(item);
                }
            } else {
                System.out.println(item + "is not in shopping list. Either add item to list or exit store. ('add item' or press any key)");
                String input = this.getInput(); 
                // spaghetti code...
                if (input == "add item") { 
                    System.out.println("What is the item you want to add?");
                    String userItem = this.getInput(); 
                    user.addToShoppingList(userItem);
                }
                // give option to add item to list and if no then choose to exit store? 
            }
        //} 
        //System.out.println("Goodbye! ");
        //store.exit(user);
    }

    /** 
     * Given the desired item of the user, suggests the next item in the inventory -- OR suggests similar item
     */
    public void suggestItem(String item) { 
        // suggests item
        // give hint about where item might be --> ie suggests different store
        // adds item to shopping list!
        // if item not in stock, suggest store name? 
        // if item does not exist then say that the item doesnt exist 
    }

    /**
     * Gets input from user & converts it to a string
     * @return string formatted user input                                                              
     */
    public String getInput() { 
        Scanner input = new Scanner(System.in);  
        input.close();
        String string = input.toString();
        string = string.trim(); 
        string = string.toLowerCase(); 
        return string; 
    }
    
    public static void main(String[] args) {
        Store store = new Store("Store", 10);
        User user = new User("Michelle", 19, "female", 1000, false, 0);
        Employee employee = new Employee(store, user); 
        employee.greetCustomer();
        employee.mainConversation();
    }
}
