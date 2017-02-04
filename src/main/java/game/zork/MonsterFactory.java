package game.zork;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Trung on 2/2/2017.
 */
public class MonsterFactory {

    public ArrayList<NormalMonster> allNormalMonsters = new ArrayList<>();
    public ArrayList<GhostMonster> allGhostMonster = new ArrayList<>();
    public ArrayList<Monster> allMonsterList = new ArrayList<>();

    ItemFactory itemFactory = new ItemFactory();

    public void setAllMonsters(){

        itemFactory.setAllItems();
        ArrayList<Potion> potions = itemFactory.allPotions;

        /* Monsters don't have Item yet // Ghost monster isWeakTo not yet set */
        NormalMonster monster1 = new NormalMonster();
        NormalMonster monster2 = new NormalMonster();
        NormalMonster monster3 = new NormalMonster();

        GhostMonster ghost1 = new GhostMonster();
        GhostMonster ghost2 = new GhostMonster();
        GhostMonster ghost3 = new GhostMonster();

        // Monster 1
        monster1.setType("normal");
        monster1.setName("Horny Devil");
        monster1.setDescription("Looks like your everyday Satan spawn");
        monster1.setHp(20);
        monster1.setDamage(10);
        monster1.setItems(potions.get(0));

        // Monster 2
        monster2.setType("normal");
        monster2.setName("Cheeky Thief");
        monster2.setDescription("Looks like that asshole back in highschool");
        monster2.setHp(30);
        monster2.setDamage(8);
        monster2.setItems(potions.get(1));

        // Monster 3
        monster3.setType("normal");
        monster3.setName("Stranger");
        monster3.setDescription("Doesn't look like I know her");
        monster3.setHp(30);
        monster3.setDamage(10);
        monster3.setItems(potions.get(2));

        // Ghost 1
        ghost1.setType("ghost");
        ghost1.setName("Memory of cat");
        ghost1.setDescription("This cat looks familiar");
        ghost1.setIsWeakTo("Candle");
        ghost1.setHp(50);
        ghost1.setDamage(15);

        // Ghost 2
        ghost2.setType("ghost");
        ghost2.setName("Memory of child");
        ghost2.setDescription("I wouldn't happen to know this kid right?");
        ghost2.setIsWeakTo("Candle");
        ghost2.setHp(80);
        ghost2.setDamage(30);

        // Ghost 3
        ghost3.setType("ghost");
        ghost3.setName("Memory of woman");
        ghost3.setDescription("Wait ... isn't that ...");
        ghost3.setIsWeakTo("Candle");
        ghost3.setHp(150);
        ghost3.setDamage(50);

        allNormalMonsters.addAll(Arrays.asList(monster1, monster2, monster3));
        allGhostMonster.addAll(Arrays.asList(ghost1, ghost2, ghost3));

        allMonsterList.addAll(allNormalMonsters);
        allMonsterList.addAll(allGhostMonster);
    }
}
