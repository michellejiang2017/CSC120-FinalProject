import java.util.ArrayList;
import java.util.HashMap;

public class Wing {
    private String name;
    private HashMap<Integer, ArrayList<Store>> floorStores = new HashMap<>();

    public Wing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStore(int floor, Store store) {
        floorStores.putIfAbsent(floor, new ArrayList<>());
        floorStores.get(floor).add(store);
    }

    public ArrayList<Store> getStores(int floor) {
        return floorStores.getOrDefault(floor, new ArrayList<>());
    }
}