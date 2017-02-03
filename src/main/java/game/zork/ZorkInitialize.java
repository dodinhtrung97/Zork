package game.zork;

import java.util.ArrayList;

/**
 * Created by Trung on 2/3/2017.
 */
public class ZorkInitialize {

    public void setZorkInit(Character player, ItemFactory itemFactory, MonsterFactory monsterFactory, Path path){

        /* Initialize Item Factory */
        itemFactory.setAllItems();

        /* Initialize Monster Factory */
        monsterFactory.setAllMonsters();

        /* Basic Character Setup  */
        ArrayList<Item> blankInventory = new ArrayList<>();

        player.setCurrentLevel(1);
        player.setCurrentPosition(0,0);
        player.setMaxHp(50);
        player.setCurrentHp(50);
        player.setDamage(10);
        player.setDefend(5);
        player.setEquippedItem(null);
        player.setInventory(blankInventory);

        /* Level Setup */
        path.initLevel1(monsterFactory, itemFactory);
        path.initLevel2(monsterFactory, itemFactory);
        path.initLevel3(monsterFactory, itemFactory);
    }
}
