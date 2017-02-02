package Zork;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Trung on 2/2/2017.
 */
public class MonsterFactory {

    public ArrayList<NormalMonster> normalMonstersList = new ArrayList<>();
    public ArrayList<GhostMonster> ghostMonsterList = new ArrayList<>();

    public static class Monsters{

        NormalMonster monster1;
        NormalMonster monster2;
        NormalMonster monster3;

        GhostMonster ghost1;
        GhostMonster ghost2;
        GhostMonster ghost3;

        public NormalMonster getMonster1(){ return this.monster1; }

        public NormalMonster getMonster2(){ return this.monster2; }

        public NormalMonster getMonster3(){ return this.monster3; }

        public GhostMonster getGhost1(){ return this.ghost1; }

        public GhostMonster getGhost2() { return this.ghost2; }

        public GhostMonster getGhost3() { return this.ghost3; }
    }

    public void setAllMonsters(){

        /* Monsters don't have Item yet // Ghost monster isWeakTo not yet set */
        Monsters allMonsters = new Monsters();

        // Monster 1
        NormalMonster monster1 = allMonsters.getMonster1();
        monster1.setType("normal");
        monster1.setName("Horny Devil");
        monster1.setDescription("Looks like your everyday Satan spawn");
        monster1.setHp(20);
        monster1.setDamage(5);
        monster1.setItems("Small Potion");

        // Monster 2
        NormalMonster monster2 = allMonsters.getMonster2();
        monster1.setType("normal");
        monster1.setName("Cheeky Thief");
        monster1.setDescription("Looks like that asshole back in highschool");
        monster1.setHp(30);
        monster1.setDamage(8);
        monster2.setItems("Medium Potion");

        // Monster 3
        NormalMonster monster3 = allMonsters.getMonster3();
        monster1.setType("normal");
        monster1.setName("Stranger");
        monster1.setDescription("Doesn't look like I know her");
        monster1.setHp(30);
        monster1.setDamage(10);
        monster3.setItems("Large Potion");

        // Ghost 1
        GhostMonster ghost1 = allMonsters.getGhost1();
        ghost1.setType("ghost");
        ghost1.setName("Memory of cat");
        ghost1.setDescription("This cat looks familiar");
        ghost1.setIsWeakTo("Candle");
        ghost1.setHp(50);
        ghost1.setDamage(15);

        // Ghost 2
        GhostMonster ghost2 = allMonsters.getGhost2();
        ghost2.setType("ghost");
        ghost2.setName("Memory of child");
        ghost2.setDescription("I wouldn't happen to know this kid right?");
        ghost2.setIsWeakTo("Candle");
        ghost2.setHp(80);
        ghost2.setDamage(30);

        // Ghost 3
        GhostMonster ghost3 = allMonsters.getGhost3();
        ghost3.setType("ghost");
        ghost3.setName("Memory of woman");
        ghost3.setDescription("Wait ... isn't that ...");
        ghost3.setIsWeakTo("Candle");
        ghost3.setHp(150);
        ghost3.setDamage(50);

        normalMonstersList.addAll(Arrays.asList(monster1, monster2, monster3));
        ghostMonsterList.addAll(Arrays.asList(ghost1, ghost2, ghost3));
    }
}
