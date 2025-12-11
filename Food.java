/**
 * File name: Food.java
 * Author: Michelle Jiang
 * Description: This class represents a food store in the mall.
 * Date: 2025-12-5
 */
public class Food extends Store {
    String name; 
    boolean type; // false for snack true for meal
    int nourishment; 

    /**
     * Constructor for Food class: a simulation for restaurants. 
     * Snack-type restaurants reduce hunger by 1 for a price of $5 and meal-type restaurants reduce hunger by 5 for a price of $20. 
     * @param name the name of the restaurant
     * @param inventory the inventory of the restaurant
     * @param type the type of restaurant (snack or meal)
     */
    public Food(String name, Inventory1 inventory, boolean type) { 
        super(name, inventory); // each store only have 1 food item
        this.name = name; 
        this.type = type; 
        if (this.type) { 
            this.nourishment = -5; 
        } else { 
            this.nourishment = -1; 
        }
    }

    /**
     * Constructor for Food class: a simulation for restaurants on level 2. 
     * @param name the name of the restaurant
     * @param inventory the inventory of the restaurant
     * @param type the type of restaurant (snack or meal)
     */
    public Food(String name, Inventory2 inventory, boolean type) { 
        super(name, inventory); // each store only have 1 food item
        this.name = name; 
        this.type = type; 
        if (this.type) { 
            this.nourishment = -5; 
        } else { 
            this.nourishment = -1; 
        }
    }

    /**
     * Get the nourishment value of the food item.
     * @return the nourishment value
     */
    public int getNourishment() {
        return this.nourishment;
    }
}
