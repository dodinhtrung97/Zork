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
    protected List<String> inventory = new ArrayList<>();

    /* All GETS methods */
    public GameMap.Coordination getCurrentPosition(){ return this.currentPosition; }

    public int getCurrentHp(){ return this.currentHp; }

    public int getMaxHp(){ return this.maxHp; }

    public int getDamage(){ return this.damage; }

    public int getDefend(){ return this.defend; }

    public List<String> getInventory(){ return this.inventory; }


    /* All SETS methods */
    public void setCurrentPosition(int x, int y){
        GameMap.Coordination newCoordinate = new GameMap.Coordination(x,y);

        this.currentPosition = newCoordinate;
    }
    public void setMaxHp(int maxHp){ this.maxHp = maxHp; }

    public void setCurrentHp(int currentHp){ this.currentHp = currentHp; }

    public void setDamage(int damage){ this.damage = damage; }

    public void setDefend(int defend){ this.defend = defend; }

    public int[] initCharacterPosition(){

        int[] characterPosition = new int[2];
        characterPosition[0] = 0;
        characterPosition[1] = 0;

        return characterPosition;
    }

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
                } else { System.out.print("Can't move to that direction"); }
            case "south":
                if (isLegalMove(y + 1)){
                    setCurrentPosition(x, y+1);
                } else { System.out.print("Can't move to that direction"); }
            case "east":
                if (isLegalMove(x - 1)){
                    setCurrentPosition(x-1, y);
                } else { System.out.print("Can't move to that direction"); }
            case "west":
                if (isLegalMove(x + 1)){
                    setCurrentPosition(x+1, y);
                } else { System.out.print("Can't move to that direction"); }
        }
    }

    public void attack(Monster monster){

        BattleStage.BattleStatus battle = new BattleStage.BattleStatus();
        battle.setBattleStatus(true);
        battle.setMonster(monster);
        battle.setCharacter(this);

        switch ( monster.getType() ) {
            case "normal":
                monster.setHp(monster.getHp() - getDamage());
                
                /* Monster retaliation */
                setCurrentHp(getCurrentHp() - monster.getDamage());
                System.out.println("Attacked " + monster.getName());
            case "ghost":
                System.out.print("Can't attack ghost with bare hands");
        }


        if ( monster.getHp()==0 ){ battle.setBattleStatus(false); }
    }

    public void attackWith(Monster monster, Weapon weapon){

    }
}
