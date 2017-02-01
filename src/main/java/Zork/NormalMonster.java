package Zork;

/**
 * Created by Trung on 1/30/2017.
 */
public class NormalMonster extends Monster {

    /* Normal monsters can't be killed with weapon */
    public boolean playerIsEquipped(Character player){

        if (player.getEquippedItem() != null){ return false; }
        else { return true; }
    }
}
