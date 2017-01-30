package Zork;

import java.util.List;

/**
 * Created by Trung on 1/30/2017.
 */
public class NormalMonster extends Monster {

    public NormalMonster(int hp, int damage, String description, String name, List<String> items){
        super(hp, damage, "normal", description, name, items);
    }

    public void retaliate(NormalMonster monster, Character character, String playerCommand){

        String conditionForHostile = "attack" + monster.name;

        if (playerCommand.equals(conditionForHostile)){
            character.currentHp -= monster.damage;
        }
    }
}
