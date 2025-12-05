# Miscellaneous
- Every class has a menu method 
- user is able to be redirected to menu? 

# Introduction
"Welcome to The Capitalism Experience!" 
- Get information about user like name and user which will determine the type of user
- everyone shops alone...this is capitalism
- Do you have a car? --> to find a parking spot
- Here's a sample shopping list (based on their age/demographics): lmk if you want to add or remove stuff
- "I see you said this..." "did you mean this?" 
- "Rate your current hunger level from 1-5" and as time progresses (like each round the hunger goes up by 1) so they will have to eat when hunger is 5
- "How much money have you brought?" --> we can start by age and give a suggestion 
- "How much capacity do you have?" same here
- "Based on your shopping list we've suggested these stores to check out first!"
- maxmium amount of non-food items in shopping list: if have car: 20 if no car: 10
- Suggest parking locations if have car
- suggest entrance location and like if they enter from a certain place the stores they see first are different so they have to map out their route differently 
- personality of user? like some people want to spend all their money and some people only care about crossing off their shopping list 

# Stores 
- Toys R Us --> like kids care abt it more
- adults can suggest grocery store
- list of all the shops and list of suggested shops (above) 
- food court with different food stalls
- luxury floor, tech (bargaining?) floor
- clothes
- different stores such as restaurants, clothing stores, gift stores, electronics stores, stalls (ie jewelry, food, etc), bathrooms, elevators, parking lot.

# Entering the Mall 
- Have shopping list --> objective is to go to places on shopping list
- but can also check out different places
- win if they finish their shopping list
- lose condition if they spend too much money
- can add stuff to shopping list during shopping experience
- can be evil and keep asking them to buy stuff and upgrade stuff
- the salespeople will keep trying to get them to buy stuff
- location attribute like coordinates on the back end and relative location on front end
- they have to figure out what stores have the items they need and as time passes they hunger which means that they spend money which gets them closer to lose condition 
- the mall is a multi-day experience 
- Can get hints from store clerks hint system: store clerk will tell them wing of next item of list using hashmap with key: store name and value as location
- every time they move will print out you're located here to keep track of location so initialize with a location (let's just have one entrance) 
- list of commands in the beginning so they can keep track of their actions
- snack can reduce hunger by 1 and be cheaper but not 0.2 the price of meal but meal will reduce hunger by 5 and be more expensive 

## User Flow 
- Enter the mall and receive a list of commands and their location
- can move to different wings of the mall and different floors of the mall
- on each location there are different stores and food spots
- they can choose to enter certain stores in that location and each time they exit they lose hunger -0.5
- in each store there are store clerks who try to sell you items
- you can ask the clerk for specific items on the shopping list and clerk will additionally suggest products
- can purchase or not purchase --> if they don't purchase leaving is harder...unskippable cutscene
- wallet decreases by amount spent
- exit store
- move to other wing if they want to
- escalators exist in every wing and user just uses escalator
- leave store when all shopping items completed (win!) or no money left (lose)
- need to find car if have car
- then leave! yay you surived the capitalism experience! the end. 
