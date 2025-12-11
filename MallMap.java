import java.util.ArrayList;
import java.util.Scanner;

/**
 * File name: Mallmap.java
 * Author: Selina Fang, Michelle Jiang, Aris Benitez-Linarez
 * Description: This class represents a shopping mall with multiple wings and floors.
 * Date: 2025-12-5
 */

public class MallMap extends Building {
    private ArrayList<Wing> wings = new ArrayList<>();
    private int wing = 0;
    private Inventory1 inventory1;
    private Inventory2 inventory2;

    /**
     * Constructor for MallMap
     * @param name the name of the mall
     * @param address the address of the mall
     * @param nFloors the number of floors in the mall
     */
    public MallMap(String name, String address, int nFloors) {
        super(name, address, nFloors);
        inventory1 = new Inventory1(); 
        inventory2 = new Inventory2(); 
        wings.add(new Wing("North"));
        wings.add(new Wing("East"));
        wings.add(new Wing("South"));
        wings.add(new Wing("West"));
        initializeStores();
    }

    /**
     * Add initial stores to the shopping mall.
     */
    private void initializeStores() {
    // the index of north wing is 0, and the user will enter the store from the north wing
    Wing north = wings.get(0);
    north.addStore(1, new Store("Walmart", inventory1));
    north.addStore(1, new Food("Whole Foods", inventory1, true));
    north.addStore(2, new Store("Play Zone", inventory2));
    north.addStore(2, new Store("Ikea", inventory2));

    // the index of east wing is 1
    Wing east = wings.get(1);
    east.addStore(1, new Store("Best Buy",inventory1));
    east.addStore(1, new Store("AT&T",inventory1));
    east.addStore(2, new Store("Barnes & Noble", inventory2));
    east.addStore(2, new Food("Starbucks", inventory2,false));

    // the index of south wing is 2
    Wing south = wings.get(2);
    south.addStore(1, new Store("Burlington",inventory1));
    south.addStore(1, new Store("Sephora",inventory1));
    south.addStore(2, new Store("Swarovski",inventory2));
    south.addStore(2, new Store("Tiffany & Co.",inventory2));

    // the index of west wing is 2
    Wing west = wings.get(3);
    west.addStore(1, new Store("Marshalls",inventory1));
    west.addStore(1, new Store("TJ Maxx",inventory1));
    west.addStore(2, new Store("Thrift Store",inventory2));
    west.addStore(2, new Store("Vintage Finds",inventory2));
    }

    /**
     * Get the current wing of the store.
     */
    public Wing getCurrentWing() {
        return wings.get(wing);
    }

    /**
     * Override the goUp method from the building class so that it can pint the location each time the user go up
     * @param user the name of the user
     */
    public void goUp(User user) {
        super.goUp();   
        showLocation();
        user.addHunger(); 
    }

    /**
     * Override the goDown method from the building class so that it can pint the location each time the user go down
     * @param user the name of the user
     */
    public void goDown(User user) {
        super.goDown();
        showLocation();
        user.addHunger(); 
    }

    /**
    * Print the user's current location in the mall and it shows both the wing and the floor number.
    */
    public void showLocation() {
        System.out.println("You are currently at: ");
        System.out.println( wings.get(wing).getName()+" Wing");
        System.out.println("Floor " + activeFloor);
    }

    /**
     * Move the the wing the user wants.
     * @param index the wing the user wants to go to
     * @param user the name of the user
     * @throw RuntimeException if the index they enter is invalid
     */
    public void moveToWing(int index, User user) {
        if (index < 0 || index > 3) {
            throw new RuntimeException("Invalid wing");
            }   
        wing = index;
        System.out.println("You moved to the " + wings.get(index).getName()+" wing.");
    }

    /**
     * Print the stores that the user is located in.
     */
    public void showStores() {
        System.out.println("The stores on floor "  + activeFloor + " in the " +wings.get(wing).getName()+ " wing are:");
        ArrayList<Store> stores = getCurrentWing().getStores(activeFloor);
        for (int i = 0; i < stores.size(); i++) {
            Store s = stores.get(i);
            System.out.println(s.getName());
        }
    }

    /**
     * Find the store the user wants to go to
     * @throw RuntimeException if the store is not in the shopping mall
     */
    public Store findStore(String name) {
        ArrayList<Store> list = getCurrentWing().getStores(activeFloor);
        for (int i = 0; i < list.size(); i++) {
            Store s = list.get(i);
            if (s.getName().toLowerCase().equals(name.toLowerCase())) {
                return s;
            }
        }
        throw new RuntimeException("The store is not found in this shopping mall.");
    }

    /**
     * Interact with a store: create employee and run shopping conversation
     */
    public void visitStore(Store store, User user, Scanner scanner) {
        Employee emp = new Employee(store, user, scanner);
        emp.greetCustomer();
        emp.mainConversation();
    }
    
    /**
     * Display current location and available options
     */
    public void showMallOptions() {
        System.out.println("\n--- MALL MENU ---");
        System.out.println("move <wing>       - Move to a wing (north, east, south, west)");
        System.out.println("up                - Go up one floor");
        System.out.println("down              - Go down one floor");
        System.out.println("location          - Show current location");
        System.out.println("visit <store>     - Enter a store");
        System.out.println("list              - Show your shopping list");
        System.out.println("add <item>        - Add an item to your shopping list");
        System.out.println("remove <item>     - Remove an item from your shopping list");
        System.out.println("stores            - Show stores on the current floor");
        System.out.println("balance           - View your balance");
        System.out.println("hunger           - View your hunger level");
        System.out.println("exit              - Leave the mall");
    }

    public static void main(String[] args) {
        
        // Initialize scanner and mall
        Scanner scanner = new Scanner(System.in);
        MallMap mall = new MallMap("The Capitalism Experience", "123 Northampton", 2);
        System.out.println("Welcome to " + mall.getName() + " located at " + mall.getAddress() + "!");

        // Create user via scanner
        System.out.print("What is your name? ");
        String name = scanner.nextLine().trim();
        
        System.out.print("How much money do you have to spend? $");
        double money = 500.0;
        try {
            money = Double.parseDouble(scanner.nextLine().trim());
        } catch (Exception e) {
            money = 500.0;
            System.out.println("Invalid input. Setting starting money to $500.0");
        }
        User user = new User(name, money);

        // Enter the mall
        mall.enter();  
        mall.showLocation(); 

        // Main shopping loop
        boolean shopping = true;  
        while (shopping) {
            mall.showMallOptions();
            System.out.print("\nEnter your choice: ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();

            try {
                switch (command) {
                    case "move":
                        if (parts.length < 2) {
                            System.out.println("Please specify a wing to move to.");
                            break;
                        }
                        String wingName = parts[1].toLowerCase();
                        int wingIndex = switch (wingName) {
                            case "north" -> 0;
                            case "east" -> 1;
                            case "south" -> 2;
                            case "west" -> 3;
                            default -> -1;
                        };
                        mall.moveToWing(wingIndex, user);
                        break;
                    case "up":
                        mall.goUp(user);
                        break;
                    case "down":
                        mall.goDown(user);
                        break;
                    case "location":
                        mall.showLocation();
                        break;
                    case "visit":
                        if (parts.length < 2) {
                            System.out.println("Please specify a store to visit.");
                            break;
                        }
                        String storeName = parts[1];
                        Store store = mall.findStore(storeName);
                        if (user.testHunger() && !(store instanceof Food)) {
                            System.out.println("You are too hungry to enter the store. Please eat some food first!");
                        } else {
                        store.enter(user);
                        mall.visitStore(store, user, scanner);
                        }
                        break;
                    case "list":
                        user.viewShoppingList();
                        break;
                    case "add":
                        if (parts.length < 2) {
                            System.out.println("Please specify an item to add.");
                            break;
                        }
                        user.addToShoppingList(parts[1]);
                        break;
                    case "remove":
                        if (parts.length < 2) {
                            System.out.println("Please specify an item to remove.");
                            break;
                        }
                        user.removeFromShoppingList(parts[1]);
                        break;
                    case "stores":
                        mall.showStores();
                        break;
                    case "balance":
                        System.out.printf("Your current balance is: $%.2f%n", user.getMoney());
                        break;
                    case "hunger":
                        System.out.println("Your current hunger level is: " + user.getHungerLevel());
                        break;
                    case "exit":
                        shopping = false;
                        user.leaveTheMall();
                        System.out.println("Thank you for visiting " + mall.getName() + "! Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                    } 
    }           catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
    
}