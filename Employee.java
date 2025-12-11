import java.util.Scanner;

/**
 * File name: Employee.java
 * Author Michelle Jiang 
 * Description: Represents an employee in a store who interacts with customers.
 * Date: 2025-11-20
 */


public class Employee {

    // Attributes 
    Store store; 
    User user; 
    Scanner scannerInput; 

    // Constructor
    public Employee(Store store, User user, Scanner scannerInput) {
        this.store = store; 
        this.user = user; 
        this.scannerInput = scannerInput; 
    }

    /**
     * Initial user greeting 
     */
    public void greetCustomer() { 
        System.out.println("Welcome to " + store.getName() + "! Here is our inventory: ");
        this.store.printInventory();
    }

    /**
     * Asks user to buy items from inventory 
     */
    public void mainConversation() { 
        boolean stillPlaying = true; 
        do {
            System.out.println("What would you like to purchase from this store? (Type the name of the item you would like to purchase. Type 'add <item>' to add to shopping list. Type 'exit' to leave store)");
            String item = this.getInput(); 
            String[] parts = item.split(" ", 2);
            String command = parts[0].toLowerCase();
            if (command == null) continue;
            if (command.equals("add")) { 
                if (parts.length < 2) {
                    System.out.println("Please specify an item to add.");
                    }
                user.addToShoppingList(parts[1]);
            } else if (command.equals("exit")) {
                stillPlaying = false;
                break; 
            } else if (store.checkList(item, user)) { 
                if (store.checkStock(item)) { 
                    store.buy(user, item);
                    if (store instanceof Food) {
                        Food foodItem = (Food) store;
                        user.eat(foodItem);
                    }
                } else {
                    System.out.println(item + " is not in the store. Please find the item in another store! (press ENTER)");
                }
            } else {
                System.out.println(item + " is not in shopping list. Either add item to list or exit store. ('add <item>' or press ENTER)");
                String input = this.getInput(); 
                if (input == null) continue; 
                if (command.equals("add")) { 
                if (parts.length < 2) {
                    System.out.println("Please specify an item to add.");
                    }
                user.addToShoppingList(parts[1]);
                }
            }
        } while (stillPlaying);
        System.out.println("Goodbye!");
        store.exit(user);
    }

    /**
     * Gets input from user & converts it to a string
     * @return string formatted user input                                                              
     */
    private String getInput() { 
        return scannerInput.nextLine().trim().toLowerCase();
    }

}
