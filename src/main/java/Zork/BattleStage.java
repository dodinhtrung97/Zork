package Zork;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * Created by Trung on 1/30/2017.
 */
public class BattleStage {

    public int battleCount = 0;
    final Random random = new Random();
    BattleStatus battleStatus = new BattleStatus();

    public int randomChance(){

        if ( random.nextBoolean() ){ return 1; }
        else { return 2; }
    }

    public static class BattleStatus extends Observable{

        private boolean isInBattle;
        private Character character;
        private Monster monster;

        public void setBattleStatus(boolean isInBattle){
            synchronized (this) {
                this.isInBattle = isInBattle;
            }
            setChanged();
            notifyObservers();
        }

        public void setCharacter(Character character){ this.character = character; }

        public void setMonster(Monster monster){ this.monster = monster; }

        public synchronized boolean getBattleStatus(){
            return isInBattle;
        }

        public Character getCharacter(){ return this.character; }

        public Monster getMonster(){ return this.monster; }
    }

    public class Notify implements Observer{

        public void observe(Observable e){
            e.addObserver(this);
        }

        @Override
        public void update(Observable e, Object arg){
            boolean status = battleStatus.getBattleStatus();
            battleCount++;

            Monster monster = battleStatus.getMonster();
            Character character = battleStatus.getCharacter();

            /* battleCount%2 == 0 means player has escaped the battle */
            if ( battleCount%2 == 0) {

                /* If monster still has hp means player fled */
                if (monster.getHp() > 0) {

                    /* Apply randomly chanced damage */
                    int potentialDamage = monster.getDamage() * 5;
                    int randomChance = randomChance();

                    if (randomChance == 1) {
                        character.setCurrentHp(character.getCurrentHp() - potentialDamage);
                    }
                }
            }
        }
    }

}
