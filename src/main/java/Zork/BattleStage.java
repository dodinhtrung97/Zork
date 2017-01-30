package Zork;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Trung on 1/30/2017.
 */
public class BattleStage {

    public static class BattleStatus extends Observable{
        private boolean isInBattle;

        public void setBattleStatus(boolean isInBattle){
            synchronized (this) {
                this.isInBattle = isInBattle;
            }
            setChanged();
            notifyObservers();
        }

        public synchronized boolean getBattleStatus(){
            return isInBattle;
        }
    }

    public class Notify implements Observer{
        public void observe(Observable e){
            e.addObserver(this);
        }

        @Override
        public void update(Observable e, Object arg){
            boolean isInBattle = ((BattleStatus) e).getBattleStatus();
        }
    }
}
