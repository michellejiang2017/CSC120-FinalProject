import java.util.HashMap;
import java.util.Map;

/**
 * File name: Inventory2.java
 * Author: Selina Fang
 * Description: 
 * Date: 2025-12-5
 */

public class Inventory2 {
    private Map<String, Map<String, Double>> inventories;
    public Inventory2() {
        inventories = new HashMap<>();
        ikea();
        playZone();
        barnes();
        starbucks();
        swarovski();
        tiffany();
        thriftStore();
        vintage();
    }

    private void ikea() {
        Map<String, Double> ikeaItems = new HashMap<>();
        ikeaItems.put("Coffee table", 499.99);
        ikeaItems.put("Chair", 49.99);
        ikeaItems.put("Lamp", 19.99);
        ikeaItems.put("Bookshelf", 59.99);
        ikeaItems.put("Couch", 399.99);
        inventories.put("ikea", ikeaItems);
    }

    private void playZone() {
        Map<String, Double> playzoneItems = new HashMap<>();
        playzoneItems.put("Toy Car", 9.99);
        playzoneItems.put("Puzzle", 14.99);
        playzoneItems.put("Plush Bear", 24.99);
        playzoneItems.put("Board Game", 29.99);
        playzoneItems.put("Action Figure", 19.99);
        inventories.put("play zone", playzoneItems);
    }

    private void barnes() {
        Map<String, Double> barnesItems = new HashMap<>();
        barnesItems.put("Novel", 12.99);
        barnesItems.put("Notebook", 3.99);
        barnesItems.put("Pen Set", 5.99);
        barnesItems.put("Calendar", 9.99);
        barnesItems.put("Bookmark", 2.99);
        inventories.put("barnes & noble", barnesItems);
    }

    private void starbucks() {
        Map<String, Double> starbucksItems = new HashMap<>();
        starbucksItems.put("Coffee", 4.99);
        starbucksItems.put("Tea", 3.49);
        starbucksItems.put("Cookie", 2.99);
        starbucksItems.put("Sandwich", 6.49);
        starbucksItems.put("Muffin", 3.99);
        inventories.put("starbucks", starbucksItems);
    }

    private void swarovski() {
        Map<String, Double> swarovskiItems = new HashMap<>();
        swarovskiItems.put("Crystal Necklace", 129.99);
        swarovskiItems.put("Crystal Bracelet", 89.99);
        swarovskiItems.put("Earrings", 79.99);
        swarovskiItems.put("Keychain", 39.99);
        inventories.put("swarovski", swarovskiItems);
    }

    private void tiffany() {
        Map<String, Double> tiffanyItems = new HashMap<>();
        tiffanyItems.put("Diamond Ring", 4990.99);
        tiffanyItems.put("Diamond Necklace", 1990.99);
        tiffanyItems.put("Bracelet", 1490.99);
        tiffanyItems.put("Watch", 4900.99);
        inventories.put("tiffany & co.", tiffanyItems);
    }

    private void thriftStore() {
        Map<String, Double> thriftItems = new HashMap<>();
        thriftItems.put("Used Jacket", 15.00);
        thriftItems.put("Vintage Hat", 12.00);
        thriftItems.put("Old Shoes", 10.00);
        thriftItems.put("Sweater", 8.00);
        thriftItems.put("Scarf", 5.00);
        inventories.put("thrift store", thriftItems);
    }

    private void vintage() {
        Map<String, Double> vintageItems = new HashMap<>();
        vintageItems.put("Retro Lamp", 35.00);
        vintageItems.put("Old Vinyl", 20.00);
        vintageItems.put("Classic Clock", 40.00);
        vintageItems.put("Antique Mirror", 60.00);
        vintageItems.put("Typewriter", 80.00);
        inventories.put("vintage finds", vintageItems);
    }

    /** 
     * Get the inventory of a certain store
     * @return the store inventory
     */
    public Map<String, Double> getInventory(String storeName) {
        String key = storeName.toLowerCase();
        if (inventories.containsKey(key)) {
            return inventories.get(key);
        } else {
            return new HashMap<>(); 
        }
    }

    /**
     * Get all inventories
     * @return all inventories
     */
    public Map<String, Map<String, Double>> getInventories() {
        return inventories;
    }
}
