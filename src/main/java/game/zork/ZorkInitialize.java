package game.zork;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Trung on 2/3/2017.
 */
public class ZorkInitialize {

    public void setZorkInit(Character player, ItemFactory itemFactory, MonsterFactory monsterFactory, GameMap gameMap){

        /* Initialize Item Factory */
        itemFactory.setAllItems();

        /* Initialize Monster Factory */
        monsterFactory.setAllMonsters();

        /* Basic Character Setup  */
        ArrayList<Item> blankInventory = new ArrayList<>();
        blankInventory.add(itemFactory.allKeyItems.get(0));

        player.setCurrentLevel(1);
        player.setNumberOfKeyItem(1);
        player.setCurrentPosition(0,0);
        player.setMaxHp(50);
        player.setCurrentHp(50);
        player.setDamage(10);
        player.setDefend(5);
        player.setEquippedItem(null);
        player.setInventory(blankInventory);

        /* Level Setup */
        gameMap.initLevel1(monsterFactory, itemFactory);
        gameMap.initLevel2(monsterFactory, itemFactory);
        gameMap.initLevel3(monsterFactory, itemFactory);
    }

    public ArrayList<Map<GameMap.Coordination, ArrayList<Object>>> initGameMaps(GameMap gameMap){

        ItemFactory itemFactory = new ItemFactory();
        MonsterFactory monsterFactory = new MonsterFactory();

        monsterFactory.setAllMonsters();
        itemFactory.setAllItems();

        gameMap.initLevel1(monsterFactory, itemFactory);
        gameMap.initLevel2(monsterFactory, itemFactory);
        gameMap.initLevel3(monsterFactory, itemFactory);

        /* It's ugly af but I don't have enough time */
        ArrayList<Map<GameMap.Coordination, ArrayList<Object>>> gameMaps = new ArrayList<>();

        gameMaps.add(gameMap.firstMap);
        gameMaps.add(gameMap.secondMap);
        gameMaps.add(gameMap.thirdMap);

        return gameMaps;
    }
}
