import java.util.Arrays;
public class MallMap extends Building {

    private String[][][] mallStores;  // wing,floor,the list of stores
    private String[][][] mallExtras;  // wing,floor,bathroom and escalators
    private int wingIndex;  // 0=N,1=E,2=S,3=W

    public MallMap(String name, String address, int nFloors) {
        super(name, address, nFloors);
        mallStores = new String[4][nFloors + 1][];
        mallExtras = new String[4][nFloors + 1][];

        // North Wing
        mallStores[0][1] = new String[]{"Walmart", "Whole Foods", "Play Zone One"};
        mallStores[0][2] = new String[]{"Furniture", "Ikea"};
        mallExtras[0][1] = new String[]{"Bathroom","Escalator"};
        mallExtras[0][2] = new String[]{"Bathroom","Escalator"};

        // East Wing
        mallStores[1][1] = new String[]{"Best Buy", "AT&T", "GameStop","Play Zone Two","Popeyes"};
        mallStores[1][2] = new String[]{"Barnes & Noble","Starbucks"};
        mallExtras[1][1] = new String[]{"Bathroom","Escalator"};
        mallExtras[1][2] = new String[]{"Bathroom","Escalator"};

        // South Wing
        mallStores[2][1] = new String[]{"Burlington","Sephora"};
        mallStores[2][2] = new String[]{"Swarovski","Tiffany & Co."};
        mallExtras[2][1] = new String[]{"Bathroom","Escalator"};
        mallExtras[2][2] = new String[]{"Bathroom","Escalator"};


        // West Wing
        mallStores[3][1] = new String[]{"Marshalls","TJ Maxx"};
        mallStores[3][2] = new String[]{"Thrift Store","Vintage Finds"};
        mallExtras[3][1] = new String[]{"Bathroom","Escalator"};
        mallExtras[3][2] = new String[]{"Bathroom","Escalator"};

        wingIndex = 0;  // start at North
    }

    private int wingToIndex(String wing) {
        wing = wing.toLowerCase();
        if (wing.equals("north")) {
            return 0;
        }
        else if (wing.equals("east")) {
            return 1;
        }
        else if (wing.equals("south")) {
            return 2;
        }
        else if (wing.equals("west")) {
            return 3;
        }
        else {
            return -1;  
        }
    }

    private String getCurrentWingName() {
        return indexToWing(wingIndex);
    }

    public void moveToWing(String wing) {
        int position = wingToIndex(wing);
        if (position <0||position>3) {
            throw new RuntimeException("Invalid wing.");
        }
        wingIndex = position;
        System.out.println("You moved to " + wing + " wing, floor " + this.activeFloor + ".");
        System.out.println("Stores here are" + Arrays.toString(mallStores[wingIndex][this.activeFloor]));
    }

    public void showLocation() {
        System.out.println("You are at " + indexToWing(wingIndex) + " Wing, Floor " + this.activeFloor);
        System.out.println("Stores here are " + Arrays.toString(mallStores[wingIndex][this.activeFloor]));
    }

    private String indexToWing(int i) {
        return Arrays.asList("North","East","South","West").get(i);
    }

    public void goUp() {
        super.goUp();
        showLocation();
    }

    public void goDown() {
        super.goDown();
        showLocation();
    }

    public void enterLocation(String name) {
        String[] stores = mallStores[wingIndex][activeFloor];
        String[] extras = mallExtras[wingIndex][activeFloor];

        for (String s : stores) {
            if (s.equalsIgnoreCase(name)) {
                System.out.println("You entered " + s + " in " + getCurrentWingName() +" Wing, Floor " + activeFloor + ".");
                return;
            }   
        }
        for (String e : extras) {
            if (e.equalsIgnoreCase(name)) {
                System.out.println("You accessed " + e + " in " + getCurrentWingName() +" Wing, Floor " + activeFloor + ".");
                return;
            }
        }
        throw new RuntimeException("That location does not exist in this shopping mall.");
    }

    public static void main(String[] args) {
       
}
