package Zork;

import java.util.Scanner;

/**
 * Created by Trung on 2/1/2017.
 */
public class ZorkRunner {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        /* Basic Character Setup  */
        Character player = new Character();
        player.setCurrentPosition(0,0);
        player.setMaxHp(50);
        player.setCurrentHp(50);
        player.setDamage(10);
        player.setDefend(5);

        while(true){

            String command = in.nextLine();

            String[] splitCommand = command.split(" ");
            String baseCommand = splitCommand[0];

            switch (baseCommand){
                case "go":
                    String direction = splitCommand[1];
                    player.go(direction);
                    System.out.println(player.getCurrentPosition().x + "," + player.getCurrentPosition().y);
            }
        }
    }
}
