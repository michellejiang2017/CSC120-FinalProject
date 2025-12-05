import java.util.HashMap;
import java.util.ArrayList;

public class Wing {
    private String name;
    private HashMap<Integer, ArrayList<Store>> floors = new HashMap<>();

    public Wing(String name) {
        this.name = name;
    }

    public void addStore(int floor, Store store) {
        floors.putIfAbsent(floor, new ArrayList<>());
        floors.get(floor).add(store);
    }

    public ArrayList<Store> getStores(int floor) {
        return floors.getOrDefault(floor, new ArrayList<>());
    }

    public String getName() {
        return name;
    }
}
