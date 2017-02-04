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

        KeyItem specialKey = new KeyItem();
        KeyItem key1 = new KeyItem();
        KeyItem key2 = new KeyItem();
        KeyItem key3 = new KeyItem();

        Equipment weapon1 = new Equipment();
        Equipment weapon2 = new Equipment();

        Potion potion1 = new Potion();
        Potion potion2 = new Potion();
        Potion potion3 = new Potion();

        /* I would've written something nice too, but due to time contrain, I copied this from my Creative Writing homework */
        /* All Key Items */
        specialKey.setKeyPhrases("I was so used to the cold of winter that the warmth of spring surprised me. I woke up 30 minutes " +
                "earlier than I usually did this morning just to make sure we wouldn’t be late for the train. I cooked my own instant noodle " +
                "for the first time, making sure that mom and dad wouldn’t spend too much time making breakfast. ");
        specialKey.setDescription("A torn piece of paper");
        specialKey.setName("Piece of paper");
        specialKey.setType("key");

        key1.setKeyPhrases("“Almost there” I dash, treading on the weeds and grasses that are ignited by the burning sunlight. Barely make it to " +
                "the slamming train doors as I pull out my hands and wipe away the drips on my cheeks.");
        key1.setDescription("A torn piece of paper");
        key1.setName("Piece of paper 1");
        key1.setType("key");

        key2.setKeyPhrases("A golden leaf pirouettes down an invisible spiral of breeze, spinning through the air as it lets itself be carried down. " +
                "It blows past my gaze and lands gently on the concrete ground, the shiny, vibrant color stands out against the solid gray beneath it. " +
                "Why am I having all the time to navigate the scenery you ask? Because I have of course, missed the damn train.");
        key2.setDescription("A torn piece of paper");
        key2.setName("Piece of paper 2");
        key2.setType("key");

        key3.setKeyPhrases("The grass has paled and stiffened with frost, and crisp, heavy snow are left clinging to the otherwise bare branches of the oak tree. For years, I have lived through all " +
                "seasons in this prison I call my home, believing them all to be necessary to my wellbeing. Yet truly, when winter calls, I refuse with a simple shake of my head that have grown " +
                "weak over time. The months rolled by regardless, and snow does fall yet again. \n" +
                "\tThe train on the other hand, is as unrelenting as the day I first saw it. Its raucous, metallic shriek heralds its apathy, rushing away in defiance of the cold and my existence.\n" +
                "\tAnd so I wave, for that is all I can do anymore.\n" +
                "\tI wave, in hope that it would gently let me in, for I can no longer chase its unwavering wheels.\n" +
                "\tI waved, but the train never slowed down.\n");
        key3.setDescription("A torn piece of paper");
        key3.setName("Piece of paper 3");
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

        allKeyItems.addAll(Arrays.asList(specialKey, key1, key2, key3));
        allEquipments.addAll(Arrays.asList(weapon1, weapon2));
        allPotions.addAll(Arrays.asList(potion1, potion2, potion3));

        allItems.addAll(allEquipments);
        allItems.addAll(allKeyItems);
        allItems.addAll(allPotions);
    }
}
