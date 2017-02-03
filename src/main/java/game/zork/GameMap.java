package game.zork;

import java.util.*;

/**
 * Created by Trung on 1/30/2017.
 */
public class GameMap {

    public static class Coordination{
        public int x;
        public int y;

        Coordination(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object a){
            if (a instanceof Coordination) {
                return this.x == ((Coordination) a).x && this.y == ((Coordination) a).y;
            }
            return false;
        }

    }

    protected Map<Coordination, ArrayList<Object>> firstMap = new HashMap<>();
    protected Map<Coordination, ArrayList<Object>> secondMap = new HashMap<>();
    protected Map<Coordination, ArrayList<Object>> thirdMap = new HashMap<>();

    public void initLevel1(MonsterFactory monsterFactory, ItemFactory itemFactory){

        /* Prepare items and monsters */
        NormalMonster monster1 = monsterFactory.allNormalMonsters.get(0);
        NormalMonster monster2 = monsterFactory.allNormalMonsters.get(1);
        Potion potion1 = itemFactory.allPotions.get(0);
        KeyItem key1 = itemFactory.allKeyItems.get(0);

        /* All legal coordinate in this level */
        Coordination start = new Coordination(0,0);
        Coordination coor1 = new Coordination(0,1);
        Coordination coor2 = new Coordination(1,1);
        Coordination coor3 = new Coordination(2,1);
        Coordination coor4 = new Coordination(3,1);
        Coordination coor5 = new Coordination(2,2);
        Coordination finish = new Coordination(2,3);

        /* All Things in this level */
        final ArrayList<Object> blankList = new ArrayList<>();

        ArrayList<Object> things1 = new ArrayList<>();
        things1.add(monster1);

        ArrayList<Object> things2 = new ArrayList<>();
        things2.add(potion1);

        ArrayList<Object> things3 = new ArrayList<>();
        things3.addAll(Arrays.asList(monster1, key1));

        ArrayList<Object> things4 = new ArrayList<>();
        things4.add(monster2);

        /* Level Setting */
        firstMap.put(start, blankList);
        firstMap.put(coor1, things1);
        firstMap.put(coor2, things2);
        firstMap.put(coor3, blankList);
        firstMap.put(coor4, things3);
        firstMap.put(coor5, things4);
        firstMap.put(finish, blankList);
    }

    public void initLevel2(MonsterFactory monsterFactory, ItemFactory itemFactory){

        /* Prepare items and monsters */
        NormalMonster monster1 = monsterFactory.allNormalMonsters.get(0);
        NormalMonster monster2 = monsterFactory.allNormalMonsters.get(1);
        GhostMonster monster3 = monsterFactory.allGhostMonster.get(0);
        Potion potion1 = itemFactory.allPotions.get(1);
        Equipment equipment1 = itemFactory.allEquipments.get(0);
        Equipment equipment2 = itemFactory.allEquipments.get(1);
        KeyItem key1 = itemFactory.allKeyItems.get(1);

        /* All legal coordinate in this level */
        Coordination start = new Coordination(0,0);
        Coordination coor1 = new Coordination(1,0);
        Coordination coor2 = new Coordination(2,0);
        Coordination coor3 = new Coordination(2,1);
        Coordination coor4 = new Coordination(3,1);
        Coordination coor5 = new Coordination(2,2);
        Coordination finish = new Coordination(2,3);


        /* All Things in this level */
        final ArrayList<Object> blankList = new ArrayList<>();

        ArrayList<Object> things1 = new ArrayList<>();
        things1.add(monster1);

        ArrayList<Object> things2 = new ArrayList<>();
        things2.addAll(Arrays.asList(monster2, equipment1));

        ArrayList<Object> things3 = new ArrayList<>();
        things3.addAll(Arrays.asList(equipment2, key1));

        ArrayList<Object> things4 = new ArrayList<>();
        things4.addAll(Arrays.asList(monster3, potion1));

        /* Level Setting */
        secondMap.put(start, blankList);
        secondMap.put(coor1, things1);
        secondMap.put(coor2, blankList);
        secondMap.put(coor3, things2);
        secondMap.put(coor4, things3);
        secondMap.put(coor5, things4);
        secondMap.put(finish, blankList);
    }

    public void initLevel3(MonsterFactory monsterFactory, ItemFactory itemFactory){

        /* Prepare items and monsters */
        NormalMonster monster1 = monsterFactory.allNormalMonsters.get(1);
        NormalMonster monster2 = monsterFactory.allNormalMonsters.get(2);
        GhostMonster monster3 = monsterFactory.allGhostMonster.get(1);
        GhostMonster monster4 = monsterFactory.allGhostMonster.get(2);
        Potion potion1 = itemFactory.allPotions.get(2);
        KeyItem key1 = itemFactory.allKeyItems.get(2);

        /* All legal coordinate in this level */
        Coordination start = new Coordination(0,0);
        Coordination coor1 = new Coordination(0,1);
        Coordination coor2 = new Coordination(0,2);
        Coordination coor3 = new Coordination(1,2);
        Coordination coor4 = new Coordination(2,2);
        Coordination coor5 = new Coordination(3,2);
        Coordination finish = new Coordination(2,3);


        /* All Things in this level */
        final ArrayList<Object> blankList = new ArrayList<>();

        ArrayList<Object> things1 = new ArrayList<>();
        things1.add(monster3);

        ArrayList<Object> things2 = new ArrayList<>();
        things2.addAll(Arrays.asList(monster2, potion1));

        ArrayList<Object> things3 = new ArrayList<>();
        things3.add(monster1);

        ArrayList<Object> things4 = new ArrayList<>();
        things4.addAll(Arrays.asList(monster1, monster2));

        ArrayList<Object> things5 = new ArrayList<>();
        things4.add(potion1);

        ArrayList<Object> things6 = new ArrayList<>();
        things4.addAll(Arrays.asList(monster4, key1));

        /* Level Setting */
        thirdMap.put(start, things1);
        thirdMap.put(coor1, things2);
        thirdMap.put(coor2, things3);
        thirdMap.put(coor3, blankList);
        thirdMap.put(coor4, things4);
        thirdMap.put(coor5, things6);
        thirdMap.put(finish, things5);
    }

    public void drawMap(Character player){

        /* Note that all maps is of size 4x4 */
        Map<Coordination, ArrayList<Object>> currentMap = player.getLevelMap();

        ArrayList<Coordination> allLegalPath = new ArrayList<>(currentMap.keySet());

        for (int i=0; i < 4; i++){
            for (int j=0; j < 4; j++){

                Coordination playerPosition = player.getCurrentPosition();
                Coordination thisPosition = new Coordination(j,i);

                if (thisPosition.equals(playerPosition)) {
                    System.out.print("x ");
                } else if (allLegalPath.contains(thisPosition)){
                    System.out.print("v ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println("\n");
        }
    }
}