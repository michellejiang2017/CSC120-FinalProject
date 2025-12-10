/**
 * File name: Food.java
 * Author: Michelle Jiang
 * Description: 
 * Date: 2025-12-5
 */
public class Food extends Store {
    String name; 
    boolean type; // false for snack true for meal
    int nourishment; 
    double price; 

    /**
     * Constructor for Food class: a simulation for restaurants. 
     * Snack-type restaurants reduce hunger by 1 for a price of $5 and meal-type restaurants reduce hunger by 5 for a price of $20. 
     * @param name the name of the restaurant
     * @param type the type of restaurant (snack or meal)
     */
    public Food(String name, String wing, String floor, boolean type) { 
        super(name); // each store only have 1 food item
        this.name = name; 
        this.type = type; 
        if (this.type) { 
            this.nourishment = -5; 
            this.price = 20.;
        } else { 
            this.nourishment = -1; 
            this.price = 5.;
        }
    }

    /**
     * A simulation for when the user dines at the restaurant. 
     * Diminishes hunger by nutrition amount and money by cost of food. 
     * @param user the name of the user
     */
    public void dine(User user) { 
        if (user == null) return;
        // reduce hunger and charge the user
        try {
            user.shop(this.price);
            user.changeHunger(this.nourishment);
        } catch (Exception e) {
            System.out.println("Could not complete purchase at " + this.name + ": " + e.getMessage());
            return; 
        }
        System.out.println(user.getName() + " ate at " + this.name + " and paid $" + this.price + ".");
    }
}
