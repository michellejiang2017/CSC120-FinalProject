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

    public MallMap(String name, String address, int nFloors) {
        super(name, address, nFloors);

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
    north.addStore(1, new Store("Walmart"));
    north.addStore(1, new Store("Whole Foods"));
    north.addStore(2, new Store("Play Zone"));
    north.addStore(2, new Store("Ikea"));

    // the index of east wing is 1
    Wing east = wings.get(1);
    east.addStore(1, new Store("Best Buy"));
    east.addStore(1, new Store("AT&T"));
    east.addStore(2, new Store("Barnes & Noble"));
    east.addStore(2, new Store("Starbucks"));

    // the index of south wing is 2
    Wing south = wings.get(2);
    south.addStore(1, new Store("Burlington"));
    south.addStore(1, new Store("Sephora"));
    south.addStore(2, new Store("Swarovski"));
    south.addStore(2, new Store("Tiffany & Co."));

    // the index of west wing is 2
    Wing west = wings.get(3);
    west.addStore(1, new Store("Marshalls"));
    west.addStore(1, new Store("TJ Maxx"));
    west.addStore(2, new Store("Thrift Store"));
    west.addStore(2, new Store("Vintage Finds"));
    }

    /**
     * Get the current wing of the store.
     */
    public Wing getCurrentWing() {
        return wings.get(wing);
    }

    /**
     * Move the the wing the user wants.
     * @param index the wing the user wants to go to
     * @throw RuntimeException if the index they enter is invalid
     */
    public void moveToWing(int index) {
        if (index < 0 || index > 3) {
            throw new RuntimeException("Invalid wing");
            }   
        wing = index;
        System.out.println("You moved to " + wings.get(index).getName());
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

    public static void main(String[] args) {

        MallMap mall = new MallMap("Mall", "Northampton", 2);
        mall.enter();  
        mall.moveToWing(0);    
        mall.showStores();        
    }
    
}