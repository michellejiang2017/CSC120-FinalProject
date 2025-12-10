import java.util.ArrayList;

/**
 * File name: Mallmap.java
 * Author: Selina Fang
 * Description: 
 * Date: 2025-12-5
 */

public class MallMap extends Building {
    private ArrayList<Wing> wings = new ArrayList<>();
    private int wing = 0;
    private Inventory1 inventory1;
    private Inventory2 inventory2;

    public MallMap(String name, String address, int nFloors) {
        super(name, address, nFloors);
        inventory1 = new Inventory1(); 
        inventory2 = new Inventory2(); 
        wings.add(new Wing("North"));
        wings.add(new Wing("East"));
        wings.add(new Wing("South"));
        wings.add(new Wing("West"));
        addInitialStores();
    }

    /**
     * Add initial stores to the shopping mall.
     */
    private void addInitialStores() {
    // the index of north wing is 0, and the user will enter the store from the north wing
    Wing north = wings.get(0);
    north.addStore(1, new Store("Walmart", inventory1));
    north.addStore(1, new Store("Whole Foods"));
    north.addStore(2, new Store("Play Zone", inventory2));
    north.addStore(2, new Store("Ikea", inventory2));

    // the index of east wing is 1
    Wing east = wings.get(1);
    east.addStore(1, new Store("Best Buy",inventory1));
    east.addStore(1, new Store("AT&T",inventory1));
    east.addStore(2, new Store("Barnes & Noble", inventory2));
    east.addStore(2, new Store("Starbucks", inventory2));

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
     * Reduce the user's hunger
     * @param user the name of the user
     */
    public void reduceHunger(User user) {
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
        user.addHunger();
        System.out.println("You moved to the " + wings.get(index).getName()+" wing.");
    }

    /**
     * Print the stores that the user is located in.
     */
    public void showStores() {
        System.out.println("The stores on floor are" + activeFloor + ":");
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
        System.out.println("balance           - View your balance");
        System.out.println("hunger           - View your hunger level");
        System.out.println("exit              - Leave the mall");
    }

    public static void main(String[] args) {

        MallMap mall = new MallMap("Mall", "Northampton", 2);
        User user = new User("Selina", 19, "female", 200, 0);

        mall.enter();  
        mall.showLocation();
        mall.moveToWing(2, user);   
        mall.goUp(user);              
    }
    
}