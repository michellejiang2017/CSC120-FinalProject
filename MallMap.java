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
        addInitialStores();
    }

    private void addInitialStores() {
    Wing north = wings.get(0);
    north.addStore(1, new Store("Walmart"));
    north.addStore(1, new Store("Whole Foods"));
    north.addStore(2, new Store("Popeyes"));
    north.addStore(2, new Store("Ikea"));

    Wing east = wings.get(1);
    east.addStore(1, new Store("Best Buy"));
    east.addStore(1, new Store("AT&T"));
    east.addStore(2, new Store("Barnes & Noble"));
    east.addStore(2, new Store("Starbucks"));

    Wing south = wings.get(2);
    south.addStore(1, new Store("Burlington"));
    south.addStore(1, new Store("Sephora"));
    south.addStore(2, new Store("Swarovski"));
    south.addStore(2, new Store("Tiffany & Co."));

    Wing west = wings.get(3);
    west.addStore(1, new Store("Marshalls"));
    west.addStore(1, new Store("TJ Maxx"));
    west.addStore(2, new Store("Thrift Store"));
    west.addStore(2, new Store("Vintage Finds"));
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

    public static void main(String[] args) {

        MallMap mall = new MallMap("Mall", "Northampton", 2);
        mall.enter();  
        mall.moveToWing(0);    
        mall.showStores();        
    }
    
}