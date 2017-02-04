Rules:
	
	Player Movements:
		1. The player may travel between levels freely (monsters are not required to be beaten)
		2. There are 4 directions: north, south, east, west
		3. The player may go 1 step at a time

	Monster:
		1. Confronting the monster will give the player 3 choices: to fight, or run away
			Kill: Gives player loots from monsters (potion, equipment)
			Run Away: Runnning away will result in enemy's death but may decrease user's hp at random with 3 times the monster's hp
		2. There is always a monster in front of the door to the next level (unless it is already beaten prio)

	Items:
		1. Consumable items will be stored and can be used upon calling a command
		2. Key items (pieces of paper) can be brought up through a command

Commands:
	
	-help:
		Bring up basic movement rules
	-look around:
		Look around the room, brings up certain elements (which direction can the player go, what's inside the room)
	-look at <object>:
		Print object description
	-pick <item>:
		pick any item that is 1 or less step away from the player
	-drop <item>:
		Self explanatory
	-attack <monster name>:
		Attack monster, monster name is mentioned when player call "look around" if they exist
 	-flee <monster name>:
		Flee from a monster
	-use <item name>:
		Consume whatever the user inputs, if <item name> is potion (and user has potion(s)), restore user's HP
	-go <direcion>:
		Advance 1 step towards the given direction (front, back, left, right)
	-equip <Equipment>:
		Equip an item, can only equip 1 item at a time, user must unequip his item before equiping a new onne
	-unequip <Equipment>:
		Unequip an equipped item
	-stat:
		Print player's stat including: HP, Number of potions, attack, defend, equipments status
	-key:
		Print the current pieces of paper the player has
		Print the current story collected and formed by the current pieces of paper possessed
	-map:
		Print map and player's location.