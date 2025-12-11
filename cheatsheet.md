This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.

- enter(User user): Allows user to enter the store of their choosing (Store.java)
- exit(User user): Allows user to exit the store, should increase hunger (Store.java)
- browse(User user): Allows user to browse items in a given store (Store.java)
- buy(User user, String itemName): Checks if user is in the store they want to buy from then allows them to buy the item they want
- goUp(): Allows user to change their activeFloor by +1
- goDown(): Allows user to change their activeFloor by -1
- showOptions(): Prints where user can go and where they end up inclusing exit, goUp, goDown, and goToFloor 
- toString(): returns location including amount of floors in building and address of building
- eat(Food food): Lowers hunger 
- move <wing>       - Move to a wing (north, east, south, west)
- visit <store>     - Enter a store
- list              - Show your shopping list
- add <item>        - Add an item to your shopping list
- remove <item>     - Remove an item from your shopping list
- stores            - Show stores on the current floor
- balance           - View your balance
- hunger           - View your hunger level
- exit              - Leave the mall


# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.

To win the user must get everything in their shopping list without running out of money!
