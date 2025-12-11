import java.util.HashMap;
import java.util.Map;

/**
 * File name: Inventory1.java
 * Author: Selina Fang
 * Description: 
 * Date: 2025-12-8
 */

public class Inventory1 {
    private Map<String, Map<String, Double>> inventories;
    public Inventory1() {
        inventories = new HashMap<>();
        walmart();
        wholeFoods();
        bestBuy();
        ATT();
        burlington();
        sephora();
        marshalls();
        TJMaxx();
    }

    private void walmart() {
        Map<String, Double> walmartItems = new HashMap<>();
        walmartItems.put("Bowl", 5.99);
        walmartItems.put("Fabric Softener", 19.99);
        walmartItems.put("Water", 1.00);
        walmartItems.put("Towel", 9.99);
        inventories.put("walmart", walmartItems);
    }

    private void wholeFoods() {
        Map<String, Double> wholeFoodsItems = new HashMap<>();
        wholeFoodsItems.put("Sub", 20.00);
        wholeFoodsItems.put("Pizza", 20.00);
        wholeFoodsItems.put("Burger", 20.00);
        wholeFoodsItems.put("Ramen", 20.99);
        wholeFoodsItems.put("Sushi", 20.49);
        inventories.put("whole foods", wholeFoodsItems);
    }

     private void bestBuy() {
        Map<String, Double> bestBuyItems = new HashMap<>();
        bestBuyItems.put("Laptop", 899.99);
        bestBuyItems.put("Headphones", 59.99);
        bestBuyItems.put("Charger", 19.99);
        bestBuyItems.put("Mouse", 14.99);
        bestBuyItems.put("Keyboard", 29.99);
        inventories.put("best buy", bestBuyItems);
    }

    private void ATT() {
        Map<String, Double> ATTItems = new HashMap<>();
        ATTItems.put("iPhone Case", 29.99);
        ATTItems.put("Screen Protector", 14.99);
        ATTItems.put("Wireless Plan", 49.99);
        ATTItems.put("SIM Card", 9.99);
        ATTItems.put("Phone Charger", 24.99);
        inventories.put("at&t", ATTItems);
    }

    private void burlington() {
        Map<String, Double> burlingtonItems = new HashMap<>();
        burlingtonItems.put("Winter Jacket", 39.99);
        burlingtonItems.put("Sneakers", 29.99);
        burlingtonItems.put("Handbag", 24.99);
        burlingtonItems.put("Hoodie", 19.99);
        burlingtonItems.put("Scarf", 7.99);
        inventories.put("burlington", burlingtonItems);
    }

    private void sephora() {
        Map<String, Double> sephoraItems = new HashMap<>();
        sephoraItems.put("Lipstick", 24.99);
        sephoraItems.put("Perfume", 59.99);
        sephoraItems.put("Moisturizer", 34.99);
        sephoraItems.put("Mascara", 19.99);
        sephoraItems.put("Foundation", 39.99);
        inventories.put("sephora", sephoraItems);
    }

    private void marshalls() {
        Map<String, Double> marshallsItems = new HashMap<>();
        marshallsItems.put("Dress", 19.99);
        marshallsItems.put("Nike Sneakers", 24.99);
        marshallsItems.put("Dinner Plate Set", 14.99);
        marshallsItems.put("Throw Pillow", 12.99);
        marshallsItems.put("Backpack", 16.99);
        inventories.put("marshalls", marshallsItems);
    }

    private void TJMaxx() {
        Map<String, Double> TJMaxxItems = new HashMap<>();
        TJMaxxItems.put("Sweater", 18.99);
        TJMaxxItems.put("Jeans", 22.99);
        TJMaxxItems.put("Candle Set", 9.99);
        TJMaxxItems.put("Blanket", 24.99);
        TJMaxxItems.put("Wallet", 14.99);
        inventories.put("tj maxx", TJMaxxItems);
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
