import java.util.ArrayList;
import java.util.HashMap;

public class Wing {
    private String name;
    private HashMap<Integer, ArrayList<Store>> floorStores = new HashMap<>();

    /**
     * Constructor for Wing
     * @param name the name of the wing
     */
    public Wing(String name) {
        this.name = name;
    }

    /**
     * Get the name of the wing
     * @return the name of the wing
     */
    public String getName() {
        return name;
    }

    /**
     * Add a store to a specific floor in the wing
     * @param floor the floor number
     * @param store the store to add
     */
    public void addStore(int floor, Store store) {
        floorStores.putIfAbsent(floor, new ArrayList<>());
        floorStores.get(floor).add(store);
    }

    /**
     * Get the list of stores on a specific floor
     * @param floor the floor number
     * @return the list of stores on that floor
     */
    public ArrayList<Store> getStores(int floor) {
        return floorStores.getOrDefault(floor, new ArrayList<>());
    }
}