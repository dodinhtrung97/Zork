Rules:
	
	Player Movements:
		1. The player may travel between levels freely (monsters are not required to be beaten)
		2. There are 4 directions: front, back, left, right
		3. The player may go 1 step at a time

	Monster:
		1. Confronting the monster will give the player 3 choices: to fight, spare, or run away
			Kill: Gives player loots from monsters (potion, equipment)
			Spare: Monster will point the player to the location of a key item, neccesary to beat the game
			Run Away: ..... It's just running away, what u wan from me desu
			
			*Note: Sparing or running away from the monster result in damage dealt to the player every action they take for a randomized 5-10 steps
		2. There is always a monster in front of the door to the next level (unless it is already beaten prio)
		3. Some monsters may be non-hostile but are killable if the player decides to be an asshole

	Items:
		1. Consumable items will be stored and can be used upon calling a command
		2. Equipable items will be automatically equipped on pick up
		3. Key items (pieces of paper) can be brought up through a command

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
		Attack monster, monster name is mentioned every time the player enters a room, or call "look"
	-attack <monster name> with <item>:
		Attack ghost type monster, similar idea as the normal attack function
	-eat <item name>:
		Consume whatever the user inputs, if <item name> is potion (and user has potion(s)), restore user's HP
	-go <direcion>:
		Advance 1 step towards the given direction (front, back, left, right)
	-stat:
		Print player's stat including: HP, Number of potions, attack, defend, equipments status
	-key:
		Print the current pieces of paper the player has
		Print the current story collected and formed by the current pieces of paper possessed
	-map:
		Print map and player's location.
		Print location of key items within the map if discovered through sparing monsters.