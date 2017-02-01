package Zork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trung on 1/30/2017.
 */
public class Character {

    protected GameMap.Coordination currentPosition;
    protected int currentHp;
    protected int maxHp;
    protected int damage;
    protected int defend;
    protected Equipment equippedItem;
    protected List<String> inventory = new ArrayList<>();

    /* All GETS methods */
    public GameMap.Coordination getCurrentPosition(){ return this.currentPosition; }

    public int getCurrentHp(){ return this.currentHp; }

    public int getMaxHp(){ return this.maxHp; }

    public int getDamage(){ return this.damage; }

    public int getDefend(){ return this.defend; }

    public Equipment getEquippedItem(){ return this.equippedItem; }

    public List<String> getInventory(){ return this.inventory; }


    /* All SETS methods */
    public void setCurrentPosition(int x, int y){
        GameMap.Coordination newCoordinate = new GameMap.Coordination(x,y);

        this.currentPosition = newCoordinate;
    }

    public void setEquippedItem(Equipment item){
        setDamage(getDamage() + item.attackPotential);

        this.equippedItem = item;
    }

    public void setMaxHp(int maxHp){ this.maxHp = maxHp; }

    public void setCurrentHp(int currentHp){ this.currentHp = currentHp; }

    public void setDamage(int damage){ this.damage = damage; }

    public void setDefend(int defend){ this.defend = defend; }



    public boolean isLegalMove(int position){

        if (position < 0 || position > 3){
            return false;
        }
        return true;
    }

    public void go(String direction){

        int y = getCurrentPosition().y;
        int x = getCurrentPosition().x;

        switch (direction) {
            case "north":
                if ( isLegalMove(y - 1) ){
                    setCurrentPosition(x, y-1);
                } else {
                    System.out.print("Can't move north");
                } break;
            case "south":
                if (isLegalMove(y + 1)){
                    setCurrentPosition(x, y+1);
                } else {
                    System.out.print("Can't move south");
                } break;
            case "east":
                System.out.println(direction);
                if (isLegalMove(x - 1)){
                    setCurrentPosition(x-1, y);
                } else {
                    System.out.print("Can't move east");
                } break;
            case "west":
                if (isLegalMove(x + 1)){
                    setCurrentPosition(x+1, y);
                } else { System.out.print("Can't move west");
                } break;
        }
    }

    public void equip(Equipment item){ setEquippedItem(item); }

    public void unequip(){ setEquippedItem(null); }

    public void use(Potion potion){
        int heal = potion.getHealPotential();
        int threshHold = getCurrentHp() + heal;

        if  ((threshHold) > getMaxHp()) { setCurrentHp(getMaxHp()); }
        else { setCurrentHp(threshHold); }
    }

    public void attack(Monster monster){

        BattleStage.BattleStatus battle = new BattleStage.BattleStatus();
        battle.setBattleStatus(true);
        battle.setMonster(monster);
        battle.setCharacter(this);

        String monsterType = monster.getType();
        int potentialTakenDamage = getCurrentHp() - monster.getDamage() + getDefend();

        switch (monsterType) {
            case "ghost":
                boolean ghostFlag = ((GhostMonster) monster).playerIsEquipped(this);
                if (ghostFlag) {
                    monster.setHp(monster.getHp() - getDamage());
                    /* Monster retaliation */
                    setCurrentHp(potentialTakenDamage);
                    System.out.println("Attacked " + monster.getName());
                } break;
            case "normal":
                boolean normalFlag = ((NormalMonster) monster).playerIsEquipped(this);
                if (normalFlag) {
                    monster.setHp(monster.getHp() - getDamage());
                    /* Monster retaliation */
                    setCurrentHp(potentialTakenDamage);
                    System.out.println("Attacked " + monster.getName());
                } break;
        }
        /* If battle's won */
        if ( monster.getHp()==0 ){
            /* Add stat bonus */
            setMaxHp(getMaxHp() + 10);
            setDamage(getDamage() + 5);
            setDefend(getDefend() + 2);
            /* Set battle state to false */
            battle.setBattleStatus(false);
        }
    }
}
