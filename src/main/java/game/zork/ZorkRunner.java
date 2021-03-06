package game.zork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Trung on 2/1/2017.
 */
public class ZorkRunner {

    public static Map<GameMap.Coordination, ArrayList<Object>> getCurrentMap(Character player, GameMap gameMap){

        Map<GameMap.Coordination, ArrayList<Object>> blankMap = new HashMap<>();
        switch (player.getCurrentLevel()){
            case 1: return gameMap.firstMap;
            case 2: return gameMap.secondMap;
            case 3: return gameMap.thirdMap;
        }
        return blankMap;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Character player = new Character();
        ItemFactory itemFactory = new ItemFactory();
        MonsterFactory monsterFactory = new MonsterFactory();
        GameMap gameMap = new GameMap();

        ZorkInitialize init = new ZorkInitialize();
        init.setZorkInit(player, itemFactory, monsterFactory, gameMap);

        while(true){

            String command = in.nextLine();
            String baseCommand;
            String argument;

            Map<GameMap.Coordination, ArrayList<Object>> thisMap = getCurrentMap(player, gameMap);

            /* Dealing with user input */
            if (command.contains(" ") && !command.equals("look around")) {
                if (command.contains("look at")){
                    baseCommand = command.substring(0,"look at".length());
                    argument = command.substring("look at".length()+1, command.length());
                } else {
                    String[] splitAt = command.split(" ", 2);
                    baseCommand = splitAt[0];
                    argument = splitAt[1];
                }
            } else {
                baseCommand = command;
                argument = null;
            }

            /* Check end game condition */
            if (player.getNumberOfKeyItems() == 4){
                for (Item i: player.getInventory()){
                    if (i.getType().equals("key")) {
                        System.out.println(i.getName());
                        System.out.println(((KeyItem) i).getKeyPhrases());
                    }
                }
                System.out.println("You have finished the game");
                System.exit(0);
            }

            /* Game starts here */
            switch (baseCommand){
                case "info":
                    System.out.println("You wake up in an abanddon mansion holding a piece of paper wherein writes an incomplete story. Led to " +
                            "believe this mansion to hold the pieces that will complete the puzzle, you set out for what you believe to be an " +
                            "adventure of a lifetime. What awaits you here however, you don't know. Yet as moth into flames, you seek the completed " +
                            "version of the story that you feel an unjustifiable connection to, for it is your flame. Thus begin the spiral into the " +
                            "command line madness.");
                    break;
                case "help":
                    System.out.println("-help:\n" +
                            "\tBring up basic movement rules\n" +
                            "-look around:\n" +
                            "\tLook around the room, brings up certain elements (which direction can the player go, what's inside the room)\n" +
                            "-look at <object>:\n" +
                            "\tPrint object description\n" +
                            "-pick <item>:\n" +
                            "\tpick any item that is 1 or less step away from the player\n" +
                            "-drop <item>:\n" +
                            "\tSelf explanatory\n" +
                            "-attack <monster name>:\n" +
                            "\tAttack monster, monster name is mentioned when player call \"look around\" if they exist\n" +
                            "-flee <monster name>:\n" +
                            "\tFlee from a monster\n" +
                            "-use <item name>:\n" +
                            "\tConsume whatever the user inputs, if <item name> is potion (and user has potion(s)), restore user's HP\n" +
                            "-go <direcion>:\n" +
                            "\tAdvance 1 step towards the given direction (front, back, left, right)\n" +
                            "-equip <Equipment>:\n" +
                            "\tEquip an item, can only equip 1 item at a time, user must unequip his item before equiping a new onne\n" +
                            "-unequip <Equipment>:\n" +
                            "\tUnequip an equipped item\n" +
                            "-stat:\n" +
                            "\tPrint player's stat including: HP, Number of potions, attack, defend, equipments status\n" +
                            "-key:\n" +
                            "\tPrint the current pieces of paper the player has\n" +
                            "\tPrint the current story collected and formed by the current pieces of paper possessed\n" +
                            "-map:\n" +
                            "\tPrint map and player's location.");
                    break;
                case "stat":
                    /* Use print instead of println here to print on the same line */
                    System.out.print("HP: " + player.getCurrentHp() + "/" + player.getMaxHp() + "\n" +
                            "Attack: " + player.getDamage() + "\n" +
                            "Defend: " + player.getDefend() + "\n" +
                            "Inventory: ");
                    if (player.getInventory().size() == 0) {
                        System.out.print("NONE");
                    } else {
                        for (Item i : player.getInventory()) {
                            System.out.print(i.getName() + ",");
                        }
                    } System.out.print("\n"); break;
                case "map":
                    gameMap.drawMap(player, gameMap);
                    break;
                case "go":
                    player.go(argument, gameMap);
                    break;
                case "use":
                    /* If nothing in inventory then for loop wont get executed */
                    if (player.getInventory().size() == 0) { System.out.println("I have no potion"); }

                    int initPlayerHp = player.getCurrentHp();

                    for (Item i: player.getInventory()){
                        /* User has item and item is potion */
                        if (i.getName().equals(argument) && i instanceof Potion) {
                            /* Enforce potion class on item */
                            Potion potion = ((Potion) i);
                            player.use(potion);
                            break;
                        }
                    }
                    /* Print something */
                    if (player.getCurrentHp() == initPlayerHp) {
                        System.out.println("I don't think my stomach will agree with that");
                    } break;
                case "equip":
                    /* If nothing in inventory then for loop wont get executed */
                    if (player.getInventory().size() == 0) { System.out.println("I have nothing to equip"); }

                    for (Item i: player.getInventory()){
                        /* User has item and item is equipment */
                        if (i.getName().equals(argument) && i.getType().equals("equipment")){
                            /* Enforce equipment class on item */
                            Equipment equipment = ((Equipment) i);
                            player.equip(equipment);
                        }
                    }
                    /* Print something */
                    if (player.getEquippedItem() == null) {
                        System.out.println("I can't equip that");
                    } break;
                case "unequip":
                    /* Check that item exists in equipment list */
                    for (Equipment i: itemFactory.allEquipments){
                        /* Find item in (Item) type and make sure user is equipped with that item */
                        if (i.getName().equals(argument) && player.getEquippedItem().equals(i)){
                            player.unequip(i);
                        }
                    } break;
                case "attack":
                    for (Monster i: monsterFactory.allMonsterList){
                        if (i.getName().equals(argument)){ player.attack(i, thisMap, gameMap); }
                    } break;
                case "look around":
                    player.lookAround(getCurrentMap(player, gameMap));
                case "look at":
                    /* Look in itemFactory */
                    for (Item i: itemFactory.allItems){
                        if (i.getName().equals(argument)) { System.out.println(i.getDescription()); }
                    }
                    /* If not in item factory then look in monsnterFactory */
                    for (Monster i: monsterFactory.allMonsterList) {
                        if (i.getName().equals(argument)) { System.out.println(i.getDescription()); }
                    }
                    break;
                case "flee":
                    for (Monster i: monsterFactory.allMonsterList){
                        if (i.getName().equals(argument)){ player.flee(i, thisMap, gameMap); }
                    } break;
                case "pick":
                    for (Item i: itemFactory.allItems){
                        if (i.getName().equals(argument)){ player.pick(i, thisMap, gameMap); }
                    } break;
                case "drop":
                    for (Item i: itemFactory.allItems){
                        if (i.getName().equals(argument)){ player.drop(i); }
                    } break;
                case "key":
                    for (Item i: player.getInventory()){
                        if (i.getType().equals("key")) {
                            System.out.println(i.getName());
                            System.out.println(((KeyItem) i).getKeyPhrases());
                        }
                    } break;
                case "quit":
                    System.exit(0);
            }
        }
    }
}