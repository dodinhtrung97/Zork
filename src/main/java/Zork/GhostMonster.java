package Zork;

/**
 * Created by Trung on 1/30/2017.
 */
class GhostMonster extends Monster {

    String isWeakTo;

    public String getIsWeakTo(){ return this.isWeakTo; }

    public void setIsWeakTo(String isWeakTo){ this.isWeakTo = isWeakTo; }

    public boolean playerIsEquipped(Character player){

        if (player.getEquippedItem().equals(getIsWeakTo())){ return true; }
        else { return false; }
    }

}