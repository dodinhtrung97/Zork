package Zork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 1/30/2017.
 */
public class GameMap {

    public static class Coordination{
        protected int x;
        protected int y;

        Coordination(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] firstLevel = new int[4][4];
    int[][] secondLevel = new int[4][4];
    int[][] thirdLevel = new int[4][4];

    Map<Coordination, ArrayList<String>> firstMap = new HashMap<>();
    Map<Coordination, ArrayList<String>> secondMap = new HashMap<>();
    Map<Coordination, ArrayList<String>> thirdMap = new HashMap<>();

    public void InitGameMap(){

        ArrayList<String> blankList = new ArrayList<>();

        for (int i=0; i < firstLevel.length; i++){
            for (int j=0; j < firstLevel.length; j++){

                Coordination spot = new Coordination(j,i);

                /* This is assuming that all 3 levels are of the same size */
                firstMap.put(spot, blankList);
                secondMap.put(spot, blankList);
                thirdMap.put(spot, blankList);
            }
        }
    }
}
