package Zork;

import java.util.List;

/**
 * Created by Trung on 1/30/2017.
 */
public class NormalMonster extends Monster {

    public void retaliate(NormalMonster monster, Character character, String playerCommand){

        String conditionForHostile = "attack" + monster.getName();

        if (playerCommand.equals(conditionForHostile)){
            character.currentHp -= monster.getDamage();
        }
    }
}
