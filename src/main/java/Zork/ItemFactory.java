package Zork;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Trung on 2/2/2017.
 */
public class ItemFactory {

    public ArrayList<KeyItem> allKeyItems = new ArrayList<>();
    public ArrayList<Equipment> allEquipments = new ArrayList<>();
    public ArrayList<Potion> allPotions = new ArrayList<>();

    public static class Items {

        KeyItem key1 = new KeyItem();
        KeyItem key2 = new KeyItem();
        KeyItem key3 = new KeyItem();

        Equipment weapon1 = new Equipment();
        Equipment weapon2 = new Equipment();

        Potion potion1 = new Potion();
        Potion potion2 = new Potion();
        Potion potion3 = new Potion();

        public KeyItem getKey1() { return this.key1; }

        public KeyItem getKey2() { return this.key2; }

        public KeyItem getKey3() { return this.key3; }

        public Equipment getWeapon1() { return this.weapon1; }

        public Equipment getWeapon2() { return this.weapon2; }

        public Potion getPotion1() { return this.potion1; }

        public Potion getPotion2() { return this.potion2; }

        public Potion getPotion3() { return this.potion3; }
    }

    public void setAllItems(){

        Items allItems= new Items();

        /* All Key Items */
        KeyItem key1 = allItems.getKey1();
        key1.setKeyPhrases("Some String 1");
        key1.setDescription("A torn piece of paper");
        key1.setName("Piece of paper");
        key1.setType("key");

        KeyItem key2 = allItems.getKey2();
        key2.setKeyPhrases("Some String 2");
        key2.setDescription("A torn piece of paper");
        key2.setName("Piece of paper");
        key2.setType("key");

        KeyItem key3 = allItems.getKey3();
        key3.setKeyPhrases("Some String 3");
        key3.setDescription("A torn piece of paper");
        key3.setName("Piece of paper");
        key3.setType("key");

        /* All Equipment Items */
        Equipment equip1 = allItems.getWeapon1();
        equip1.setAttackPotential(15);
        equip1.setDefendPotential(0);
        equip1.setName("Candle");
        equip1.setType("equipment");

        Equipment equip2 = allItems.getWeapon2();
        equip2.setDefendPotential(10);
        equip2.setAttackPotential(0);
        equip2.setName("Burned Shirt");
        equip2.setType("equipment");

        /* All Potions Items */
        Potion potion1 = allItems.getPotion1();
        potion1.setHealPotential(20);
        potion1.setName("Small Potion");
        potion1.setType("potion");
        potion1.setDescription("Looks edible");

        Potion potion2 = allItems.getPotion2();
        potion2.setHealPotential(30);
        potion2.setName("Medium Potion");
        potion2.setType("potion");
        potion2.setDescription("Looks edible");

        Potion potion3 = allItems.getPotion3();
        potion3.setHealPotential(50);
        potion3.setName("Large Potion");
        potion3.setType("potion");
        potion3.setDescription("Looks edible");

        allKeyItems.addAll(Arrays.asList(key1, key2, key3));
        allEquipments.addAll(Arrays.asList(equip1, equip2));
        allPotions.addAll(Arrays.asList(potion1, potion2, potion3));
    }
}
