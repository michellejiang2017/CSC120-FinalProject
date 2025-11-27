public class Food {
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
    public Food(String name, boolean type) { 
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
     * @param hunger
     * @param money
     */
    public void dine(int hunger, double money) { 
        hunger += this.nourishment; 
        money -= this.price; 
    }
}
