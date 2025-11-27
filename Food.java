public class Food {
    String name; 
    boolean type; // false for snack true for meal
    int nourishment; 
    double price; 

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

    public void dine(int hunger, double money) { 
        hunger += this.nourishment; 
        money -= this.price; 
    }
}
