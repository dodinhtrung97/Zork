package Zork;

import java.util.Scanner;

/**
 * Created by Trung on 2/1/2017.
 */
public class ZorkRunner {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Character player = new Character();
        ItemFactory itemFactory = new ItemFactory();
        MonsterFactory monsterFactory = new MonsterFactory();

        ZorkInitialize init = new ZorkInitialize();
        init.setZorkInit(player, itemFactory, monsterFactory);

        while(true){

            String command = in.nextLine();

            String[] splitCommand = command.split(" ",2);
            String baseCommand = splitCommand[0];
            String argument = splitCommand[1];

            switch (baseCommand){
                case "go":
                    player.go(argument);
                    System.out.println(player.getCurrentPosition().x + "," + player.getCurrentPosition().y);
                    break;
                case "use":
                    for (Item i: player.getInventory()){
                        /* User has item and item is potion */
                        if (i.getName().equals(argument) && i.getType().equals("potion")) {
                            /* Enforce potion class on item */
                            Potion potion = ((Potion) i);
                            player.use(potion);
                        } else {
                            /* Print something */
                            System.out.println("I don't think my stomach will agree with that");
                        }
                    } break;
                case "equip":
                    for (Item i: player.getInventory()){
                        /* User has item and item is equipment */
                        if (i.getName().equals(argument) && i.getType().equals("equipment")){
                            /* Enforce equipment class on item */
                            Equipment equipment = ((Equipment) i);
                            player.equip(equipment);
                        } else {
                            /* Print something */
                            System.out.println("I don't have that item");
                        }
                    } break;
                case "unequip":
                    if (player.getEquippedItem() != null){
                        for (Equipment i: itemFactory.allEquipments){
                            if (i.getName().equals(argument)){
                                player.unequip(i);
                            } else {
                                System.out.println("I'm not equipped with that");
                            }
                        }
                    } break;
            }
        }
    }
}
