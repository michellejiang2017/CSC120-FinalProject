This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.

- enter(User user): Allows user to enter the store of their choosing (Store.java)
- exit(User user): Allows user to exit the store, should increase hunger (Store.java)
- browse(User user): Allows user to browse items in a given store (Store.java)
- buy(User user, String itemName): 
- restock(String itemName, int amount):
- addItem(String itemName, double price, int amount)
- goUp(): Allows user to change their activeFloor by +1
- goDown(): Allows user to change their activeFloor by -1
- showOptions(): Prints where user can go and where they end up inclusing exit, goUp, goDown, and goToFloor 
- toString(): returns lovation including amount of floors in building and address of building
- dine(int hunger, double money): Lowers hunger 

public void dine(int hunger, double money) { 
        hunger += this.nourishment; 
        money -= this.price; 
    }
}


# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.
