import java.util.ArrayList;
import java.util.List;

public class Bathroom {
    private String name;
    private String gender;   
    private int capacity;
    private List<User> inside;  

    public Bathroom(String name, String gender, int capacity) {
        this.name = name;
        this.gender = gender;
        this.capacity = capacity;
        this.inside = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void use(User user) {
        
    }

    public void leave(User user) {
        
    }

}