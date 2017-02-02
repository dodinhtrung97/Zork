package Zork;

/**
 * Created by Trung on 2/3/2017.
 */
public class ZorkInitialize {

    public void setZorkInit(Character player, ItemFactory itemFactory, MonsterFactory monsterFactory){

        /* Initialize Item Factory */
        itemFactory.setAllItems();

        /* Initialize Monster Factory */
        monsterFactory.setAllMonsters();

        /* Basic Character Setup  */
        player.setCurrentPosition(0,0);
        player.setMaxHp(50);
        player.setCurrentHp(50);
        player.setDamage(10);
        player.setDefend(5);
    }
}
