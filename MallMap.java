import java.util.ArrayList;

public class MallMap extends Building {
    private ArrayList<Wing> wings = new ArrayList<>();
    private int wingIndex = 0;

    public MallMap(String name, String address, int nFloors) {
        super(name, address, nFloors);

<<<<<<< HEAD
        wings.add(new Wing("North"));
        wings.add(new Wing("East"));
        wings.add(new Wing("South"));
        wings.add(new Wing("West"));
=======
        // North Wing
        mallStores[0][1] = new String[]{"Walmart", "Whole Foods", "Play Zone One"};
        mallStores[0][2] = new String[]{"Furniture", "Ikea"};
        mallExtras[0][1] = new String[]{"Bathroom","Escalator"};
        mallExtras[0][2] = new String[]{"Bathroom","Escalator"};

        // East Wing
        mallStores[1][1] = new String[]{"Best Buy", "AT&T", "GameStop","Play Zone Two","Insomnia Cookies"};
        mallStores[1][2] = new String[]{"Barnes & Noble","Starbucks"};
        mallExtras[1][1] = new String[]{"Bathroom","Escalator"};
        mallExtras[1][2] = new String[]{"Bathroom","Escalator"};

        // South Wing
        mallStores[2][1] = new String[]{"Burlington","Sephora", "McDonald's"};
        mallStores[2][2] = new String[]{"Swarovski","Tiffany & Co.", "In & Out"};
        mallExtras[2][1] = new String[]{"Bathroom","Escalator"};
        mallExtras[2][2] = new String[]{"Bathroom","Escalator"};


        // West Wing
        mallStores[3][1] = new String[]{"Marshalls","TJ Maxx", "NiceTea"};
        mallStores[3][2] = new String[]{"Thrift Store","Vintage Finds", "Popeyes"};
        mallExtras[3][1] = new String[]{"Bathroom","Escalator"};
        mallExtras[3][2] = new String[]{"Bathroom","Escalator"};

        wingIndex = 0;  // start at North
>>>>>>> a14376c7578516686aa17e0d5ce5401dfc6d7813
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