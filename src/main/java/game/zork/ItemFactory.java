package game.zork;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Trung on 2/2/2017.
 */
public class ItemFactory {

    public ArrayList<KeyItem> allKeyItems = new ArrayList<>();
    public ArrayList<Equipment> allEquipments = new ArrayList<>();
    public ArrayList<Potion> allPotions = new ArrayList<>();
    public ArrayList<Item> allItems = new ArrayList<>();

    public void setAllItems(){

        KeyItem key1 = new KeyItem();
        KeyItem key2 = new KeyItem();
        KeyItem key3 = new KeyItem();

        Equipment weapon1 = new Equipment();
        Equipment weapon2 = new Equipment();

        Potion potion1 = new Potion();
        Potion potion2 = new Potion();
        Potion potion3 = new Potion();

        /* All Key Items */
        key1.setKeyPhrases("Some String 1");
        key1.setDescription("A torn piece of paper");
        key1.setName("Piece of paper");
        key1.setType("key");

        key2.setKeyPhrases("Some String 2");
        key2.setDescription("A torn piece of paper");
        key2.setName("Piece of paper");
        key2.setType("key");

        key3.setKeyPhrases("Some String 3");
        key3.setDescription("A torn piece of paper");
        key3.setName("Piece of paper");
        key3.setType("key");

        /* All Equipment Items */
        weapon1.setAttackPotential(15);
        weapon1.setDefendPotential(0);
        weapon1.setName("Candle");
        weapon1.setType("equipment");

        weapon2.setDefendPotential(10);
        weapon2.setAttackPotential(0);
        weapon2.setName("Burned Shirt");
        weapon2.setType("equipment");

        /* All Potions Items */
        potion1.setHealPotential(20);
        potion1.setName("Small Potion");
        potion1.setType("potion");
        potion1.setDescription("Looks edible");

        potion2.setHealPotential(30);
        potion2.setName("Medium Potion");
        potion2.setType("potion");
        potion2.setDescription("Looks edible");

        potion3.setHealPotential(50);
        potion3.setName("Large Potion");
        potion3.setType("potion");
        potion3.setDescription("Looks edible");

        allKeyItems.addAll(Arrays.asList(key1, key2, key3));
        allEquipments.addAll(Arrays.asList(weapon1, weapon2));
        allPotions.addAll(Arrays.asList(potion1, potion2, potion3));

        allItems.addAll(allEquipments);
        allItems.addAll(allKeyItems);
        allItems.addAll(allPotions);
    }
}
