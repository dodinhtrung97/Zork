package Zork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trung on 1/30/2017.
 */
public class Character {

    protected int[] currentPosition;
    protected int currentHp;
    protected int maxHp;
    protected int damage;
    protected int defend;
    protected List<String> inventory = new ArrayList<>();

    public Character(){

        this.currentPosition = initCharacterPosition();
        this.currentHp = 100;
        this.maxHp = 100;
        this.damage = 10;
        this.defend = 10;
        this.inventory = new ArrayList<>();
    }

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

        switch (direction) {
            case "north":
                if (isLegalMove(currentPosition[1]--)){
                    currentPosition[1]--;
                } else { System.out.print("Can't move to that direction"); }
            case "south":
                if (isLegalMove(currentPosition[1]++)){
                    currentPosition[1]++;
                } else { System.out.print("Can't move to that direction"); }
            case "east":
                if (isLegalMove(currentPosition[0]--)){
                    currentPosition[0]--;
                } else { System.out.print("Can't move to that direction"); }
            case "west":
                if (isLegalMove(currentPosition[0]++)){
                    currentPosition[0]++;
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
                monster.setHp(monster.getHp() - damage);
            case "ghost":
                System.out.print("Can't attack ghost with bare hands");
        }

        if ( monster.getHp()==0 ){ battle.setBattleStatus(false); }
    }

    public void attackWith(Monster monster, Weapon weapon){

    }
}
