import java.util.ArrayList;

public class MallMap extends Building {
    private ArrayList<Wing> wings = new ArrayList<>();
    private int wingIndex = 0;

    public MallMap(String name, String address, int nFloors) {
        super(name, address, nFloors);

        wings.add(new Wing("North"));
        wings.add(new Wing("East"));
        wings.add(new Wing("South"));
        wings.add(new Wing("West"));
    }

    public Wing getCurrentWing() {
        return wings.get(wingIndex);
    }

    public void moveToWing(int index) {
        if (index < 0 || index > 3) throw new RuntimeException("Invalid wing");
        wingIndex = index;
        System.out.println("Moved to " + wings.get(index).getName());
    }

    public void showStores() {
        System.out.println("Stores on floor " + activeFloor + ":");
        for (Store s : getCurrentWing().getStores(activeFloor)) {
            System.out.println(s.getName());
        }
    }

    public Store findStore(String name) {
        for (Store s : getCurrentWing().getStores(activeFloor)) {
            if (s.getName().equalsIgnoreCase(name)) return s;
        }
        throw new RuntimeException("Store not found.");
    }

    
}