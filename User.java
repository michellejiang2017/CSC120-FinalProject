import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String name;
    private double money;
    private ArrayList<String> shoppingList; 
    private int hunger; // starts at zero and increases with every exit. 

    // use scanner to get input for the constructor
    public User(String name, int age, String gender, double money, int hunger) {
        this.name = name;
        this.money = money;
        this.shoppingList = new ArrayList<>();
        this.hunger = hunger; 
        System.out.println("I see you have $" + money + " to spend today.");
    }

    public String getName() {
        return this.name;
    }

<<<<<<< HEAD
    public double getMoney() { 
        return money; 
    }

    public void spendMoney(double amount) {
        this.money -= amount;
    }

    public List<String> getShoppingList() {
        return shoppingList;
    }

    public void addToShoppingList(String item) {
       
=======
    /**
     * Gets input from user & converts it to a string
     * @return string formatted user input 
     */
    public String getInput() { 
        Scanner input = new Scanner(System.in);  
        input.close();
        String string = input.toString();
        string = string.trim(); 
        string = string.toLowerCase(); 
        return string; 
    }

    public ArrayList<String> getList() { 
        return this.shoppingList; 
    }
    
     public void addToShoppingList(String item, Store store) {
        // if item exists in inventory then add to shopping list else sout "item not found"
        if (store.checkStock(item) == true) {
            this.shoppingList.add(item);
            System.out.println("You have added " + item + " into your shopping list.");
        }
>>>>>>> a14376c7578516686aa17e0d5ce5401dfc6d7813
    }

    public void removeFromShoppingList(String item) {
        
    }

    public void viewShoppingList() {
        
    }

    public void enterTheMall() {

    }

    public void leaveTheMall() { 

    }

    public void shop(double price) { 

    }

<<<<<<< HEAD
    public void eat(String food) { 
        
=======
    public void eat(Food food) { 
        food.dine(this.hunger, this.money);
>>>>>>> a14376c7578516686aa17e0d5ce5401dfc6d7813
    }

    public void play(String game) { 

    }
}  