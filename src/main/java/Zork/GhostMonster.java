package Zork;

/**
 * Created by Trung on 1/30/2017.
 */
class GhostMonster extends Monster {

    Equipment isWeakTo;

    public Equipment getIsWeakTo(){ return this.isWeakTo; }

    public void setIsWeakTo(Equipment isWeakTo){ this.isWeakTo = isWeakTo; }

    public boolean playerIsEquipped(Character player){

        if (player.getEquippedItem().equals(getIsWeakTo())){ return true; }
        else { return false; }
    }

}