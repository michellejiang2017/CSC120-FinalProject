import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int age;
    private String gender;
    private double money;
    private boolean hasCar;
    private int parkingSpot;
    private List<String> shoppingList; 
    private int hunger; 

    // use scanner to get input for the constructor
    public User(String name, int age, String gender, double money, boolean hasCar) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.money = money;
        this.hasCar = hasCar;
        this.parkingSpot = -1;
        this.shoppingList = new ArrayList<>();
        this.hunger = 0; 
    }

    public String getName() {
        return this.name;
    }

    public void addToShoppingList(String item) {
       
    }

    public void removeFromShoppingList(String item) {
        
    }

    public void viewShoppingList() {
        
    }

    public void enterTheMall() {

    }

    public void leaveTheMall() { 

    }

    public void park(int spotNumber) { 

    }

    public void shop(double price) { 

    }

    public void useBathroom() { 

    }

    public void eat(String food) { 
        
    }

    public void play(String game) { 

    }
}