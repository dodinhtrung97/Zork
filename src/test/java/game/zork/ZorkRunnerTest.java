package game.zork;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Trung on 2/4/2017.
 */
public class ZorkRunnerTest{

    public static Map<GameMap.Coordination, ArrayList<Object>> getCurrentMap(Character player, GameMap gameMap){

        Map<GameMap.Coordination, ArrayList<Object>> blankMap = new HashMap<>();
        switch (player.getCurrentLevel()){
            case 1: return gameMap.firstMap;
            case 2: return gameMap.secondMap;
            case 3: return gameMap.thirdMap;
        }
        return blankMap;
    }

    @Test
    public void main() throws Exception {
        Character player = new Character();
        ItemFactory itemFactory = new ItemFactory();
        MonsterFactory monsterFactory = new MonsterFactory();
        GameMap gameMap = new GameMap();

        ZorkInitialize init = new ZorkInitialize();
        init.setZorkInit(player, itemFactory, monsterFactory, gameMap);

        /* Test initialization */
        assertEquals(50, player.getCurrentHp());
        assertEquals(50, player.getMaxHp());

        /* Test Inventory */
        ArrayList<Item> blankList = new ArrayList<>();

        // Player has 1 key item at beginning
        assertEquals(blankList.size(), player.getInventory().size() - 1);

        // Correct item
        assertEquals("Piece of paper", player.getInventory().get(0).getName());

        // Add item
        Potion potion = itemFactory.allPotions.get(0); // Small Potion
        player.getInventory().add(potion);
        player.setInventory(player.getInventory());

        // Size is now 2
        assertEquals(2, player.getInventory().size());
        assertTrue(player.getInventory().contains(potion));

        // Remove item
        player.getInventory().remove(potion);
        assertFalse(player.getInventory().contains(potion));


        /* Test movement */
        GameMap.Coordination coordinate = new GameMap.Coordination(5,10);
        assertFalse(player.isLegalMove(coordinate, gameMap));

        // Within boundary but not within legal path
        GameMap.Coordination coordinate2 = new GameMap.Coordination(3,2);
        assertFalse(player.isLegalMove(coordinate2, gameMap));
        // Within legal path
        GameMap.Coordination coordinate3 = new GameMap.Coordination(0,1);
        assertTrue(player.isLegalMove(coordinate3, gameMap));

        // Go north from 0,0
        player.go("north", gameMap);
        GameMap.Coordination coordinate4 = new GameMap.Coordination(0,0);
        assertEquals(coordinate4, player.getCurrentPosition());
        // Go south from 0,0
        player.go("south", gameMap);
        GameMap.Coordination coordinate5 = new GameMap.Coordination(0,1);
        assertEquals(coordinate5, player.getCurrentPosition());

        // attack
        Monster monster = monsterFactory.allMonsterList.get(0);
        int initualHP = monster.getHp();
        Map<GameMap.Coordination, ArrayList<Object>> thisMap = getCurrentMap(player, gameMap);
        player.attack(monster, thisMap, gameMap);
        assertEquals(monster.getHp(), initualHP - player.getDamage());

        // equip
        Equipment equipment = itemFactory.allEquipments.get(0);
        int initualDamage = player.getDamage();
        int initualDefend = player.getDefend();

        player.setEquippedItem(equipment);
        assertEquals(player.getDamage(), initualDamage + equipment.getDamagePotential());
        assertEquals(player.getDefend(), initualDefend + equipment.getDefendPotential());

        // unequip
        player.unequip(equipment);
        assertEquals(player.getDamage(), initualDamage);
        assertEquals(player.getDefend(), initualDefend);

        // Pick
        int initualSize = player.getInventory().size();

        // Can't pick potion at 0,0 because there's no potion there
        player.pick(potion, thisMap, gameMap);
        assertEquals(initualSize, player.getInventory().size());

        // Can pick now
        player.go("south", gameMap);
        // There's a monster here, no item
        player.attack(monster, thisMap, gameMap);
        player.attack(monster, thisMap, gameMap);
        // Killed monster, it drops item
        player.pick(potion, thisMap, gameMap);
        assertEquals(player.getInventory().size(), initualSize + 1);

        // Use potion
        player.setCurrentHp(20);
        player.use(potion);
        assertEquals(20 + potion.getHealPotential(), player.getCurrentHp());

        // Can't drop potion now that its not there (in print out)
        player.drop(potion);
    }

}