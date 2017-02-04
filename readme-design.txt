*MAP EXPLANATION:
	Map is constructed using a two-dimensional list
	Item and character position will be printed out as (x,y)
	Other things in a room will be stored as such

Functions:
	Help: Print built in help message to terminal
	Look at <Object>: Print object description
	Look around: Print location description
	Map: Print map, character position and item potion is discovereed
	Use <Item>: Use potion is <Item> is potion, print other message otherwise
	Attack <Object>: Attack an enemy
	Pick <Item>: Pick item
	Drop <Item>: Drop item
	Equip <Equipment>: Equip item
	Unequip <Equipment>: Unequip item

Diagram Explanation:
	The game will use a basic RPG setup, that is to say, all of its basic functions (described above). Once the user starts up the game, the program will wait for their input and continue through that process until the player either quit or finish the game.
	Player will be able to pick up items along the way that may help them advance through the game or weapons that will help them defeat a specific type of enemy (ghost)
	
	There are 2 types of monster: normal (hostile, can be killed with normal attack), and ghost (non-hostile, need specific item to kill).
	There are 3 types of items: Key item (Use to open up a new section to the paragraph that is the main objective of the game), potion (edible, heal hp), and equipment, which are equipped upon pick up
	
	Monster can be fled from, effectively killed, but may deal 3 times its damage to the player by doing so

*There will be 3 levels, each with there different number of rooms and treasure to discover and they won't (hopefully) be constructed the same way. The incentive of this game is for the player to discover 3 pieces of key items in each level, so the levels themselves mechanically might not vary. That said, ghost type monster will only happen in the later part of the game so there's that.

Inheritance Explanation:
	Both types of monster have similar basic functions in that they can attack(), chase(), and beSpared()
	Ghost: is non-hostile and required specific weapon to be defeated
	Normal: is hostile and can be defeated in any way
	Hence the inheritance for these 2 types of monster

	All 3 types of item have similar function in that they are pickable , droppable and inspectable using the description attached to them
	Key: can be called upon to read the paragraph (main objective) so far (further described in readme-instruction)
	Potion: can be consumed for hp regeneration
	Equipment: is equipped upon pick up