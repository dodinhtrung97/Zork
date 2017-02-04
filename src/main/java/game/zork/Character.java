package game.zork;

import java.util.*;

/**
 * Created by Trung on 1/30/2017.
 */
public class Character {

    protected GameMap.Coordination currentPosition;
    protected int level;
    protected int currentHp;
    protected int maxHp;
    protected int damage;
    protected int defend;
    protected Equipment equippedItem;
    protected List<Item> inventory = new ArrayList<>();

    /* All GETS methods */
    public GameMap.Coordination getCurrentPosition(){ return this.currentPosition; }

    public int getLevel(){ return this.level; }

    public int getCurrentHp(){ return this.currentHp; }

    public int getMaxHp(){ return this.maxHp; }

    public int getDamage(){ return this.damage; }

    public int getDefend(){ return this.defend; }

    public Equipment getEquippedItem(){ return this.equippedItem; }

    public List<Item> getInventory(){ return this.inventory; }

    public Map<GameMap.Coordination, ArrayList<Object>> getLevelMap(){

        GameMap gameMap = new GameMap();
        ZorkInitialize zorkInitialize = new ZorkInitialize();
        Map<GameMap.Coordination, ArrayList<Object>> notGoingToHappen = new HashMap<>();

        ArrayList<Map<GameMap.Coordination, ArrayList<Object>>> allMaps = zorkInitialize.initGameMaps(gameMap);

        switch (getLevel()){
            case 1: return allMaps.get(0);
            case 2: return allMaps.get(1);
            case 3: return allMaps.get(2);
        }

        return notGoingToHappen;
    }

    /* All SETS methods */
    public void setCurrentPosition(int x, int y){
        GameMap.Coordination newCoordinate = new GameMap.Coordination(x,y);

        this.currentPosition = newCoordinate;
    }

    public void setCurrentLevel(int level){ this.level = level; }

    public void setEquippedItem(Equipment item){
        if (item != null){
            setDamage(getDamage() + item.getDamagePotential());
            setDefend(getDefend() + item.getDefendPotential());
        }
        this.equippedItem = item;
    }

    public void setMaxHp(int maxHp){ this.maxHp = maxHp; }

    public void setCurrentHp(int currentHp){ this.currentHp = currentHp; }

    public void setDamage(int damage){ this.damage = damage; }

    public void setDefend(int defend){ this.defend = defend; }

    public void setInventory(List<Item> inventory){ this.inventory = inventory; }


    /* Functions supporting player actions */

    /**
     *
     * @param position current character position in custom (Coordination) type
     * @return boolean of whether or not a requested movement is legal
     */
    public boolean isLegalMove(GameMap.Coordination position){

        Map<GameMap.Coordination, ArrayList<Object>> levelMap = getLevelMap();
        ArrayList<GameMap.Coordination> checkLegal = new ArrayList<>(levelMap.keySet());

        /* If requested position is within legal path */
        if (checkLegal.contains(position)){ return true; }
        else { return false; }
    }

    /**
     *
     * @param item input of type (Item)
     * @return boolean of whether or not item exist at character's current position
     */
    public boolean itemExist(Item item){

        Map<GameMap.Coordination, ArrayList<Object>> mapLevel = getLevelMap();
        GameMap.Coordination currentPosition = getCurrentPosition();

        for (Object i: mapLevel.get(currentPosition)){
            if (i instanceof Item && ((Item) i).getName() == item.getName()){ return true; }
        }
        return false;
    }

    /**
     *
     * @param monster input of type (Monster)
     * @return boolean of whether or not monster exist at character's current position
     */
    public boolean monsterExist(Monster monster){

        Map<GameMap.Coordination, ArrayList<Object>> mapLevel = getLevelMap();
        GameMap.Coordination currentPosition = getCurrentPosition();

        for (Object i: mapLevel.get(currentPosition)){
            if (i instanceof Monster && ((Monster) i).getName() == monster.getName()){ return true; }
        }
        return false;
    }

    public void postBattle(Monster monster){
        /* If battle's finished */
        if ( monster.getHp() <= 0 ){
            /* Add stat bonus */
            setMaxHp(getMaxHp() + 10);
            setDamage(getDamage() + 5);
            setDefend(getDefend() + 2);

            /* Drop items and delete monster from current position */
            Map<GameMap.Coordination, ArrayList<Object>> thisMap = getLevelMap();
            ArrayList<Object> thisPositionItem = thisMap.get(getCurrentPosition());

            if (monster.getItem() != null){ thisPositionItem.add(monster.getItem()); }
            thisMap.put(getCurrentPosition(), thisPositionItem);
        }
    }

    /**
     *
     * @param direction requested movement
     * set character new position if requested movement is legal
     */
    public void go(String direction){

        int y = getCurrentPosition().y;
        int x = getCurrentPosition().x;

        switch (direction) {
            case "north":
                if ( isLegalMove(new GameMap.Coordination(x,y - 1)) ){
                    setCurrentPosition(x, y-1);
                } else {
                    System.out.print("There's a wall over north\n");
                } break;
            case "south":
                if ( isLegalMove(new GameMap.Coordination(x,y + 1)) ){
                    setCurrentPosition(x, y+1);
                } else {
                    System.out.print("There's a wall over south\n");
                } break;
            case "east":
                System.out.println(direction);
                if ( isLegalMove(new GameMap.Coordination(x - 1,y)) ){
                    setCurrentPosition(x-1, y);
                } else {
                    System.out.print("There's a wall over east\n");
                } break;
            case "west":
                if ( isLegalMove(new GameMap.Coordination(x + 1,y)) ){
                    setCurrentPosition(x+1, y);
                } else { System.out.print("There's a wall over west\n");
                } break;
        }

        GameMap.Coordination newPosition = getCurrentPosition();

        /* 2,3 is the set finish point of any level */
        if (newPosition.x == 2 && newPosition.y == 3) {
            /* If at 2,3 then switch level and set position to 0,0 */
            setCurrentLevel(getLevel() + 1);
            setCurrentPosition(0,0);
        }
    }

    /**
     *
     * @param item requested equipment item in custome type (Equipment)
     * set player equipped item, adds bonus to character's stat
     */
    public void equip(Equipment item){
        /* User can only equip 1 item at a time */
        if (getEquippedItem() == null) { setEquippedItem(item); }
        else { System.out.println("I must unequip my old item first"); }
    }

    /**
     *
     * @param item requested equipment item in custome type (Equipment)
     * set player equipped item to null, remove item bonus
     */
    public void unequip(Equipment item){
        if (getEquippedItem() == null){
            System.out.println("I have nothing to unequip");
        } else if (!getEquippedItem().equals(item)){
            System.out.println("I'm not equipped with that");
            return;
        }

        /* Count for both armor and weapon */
        setDefend(getDefend() - item.getDefendPotential());
        setDamage(getDamage() - item.getDamagePotential());

        setEquippedItem(null);
    }

    /**
     *
     * @param potion requested consumtion of item in custome type (Potion)
     * add to character's HP to a maximum of character's max HP
     */
    public void use(Potion potion){

        int heal = potion.getHealPotential();
        int threshHold = getCurrentHp() + heal;

        if  ((threshHold) > getMaxHp()) { setCurrentHp(getMaxHp()); }
        else { setCurrentHp(threshHold); }
    }

    /**
     *
     * @param item requested item item in custome type (Item)
     * Remove item from player's inventory
     */
    public void drop(Item item){

        if (getInventory().contains(item.getName())) {
            /* key and equipment items are required to finish the game */
            if (item.getType().equals("key") || item.getType().equals("equipment")) {
                System.out.println("I don't think I should drop that");
                return;
            } else {
                getInventory().remove(item);
                setInventory(getInventory());
            }
        } else { System.out.println("There's nothing to drop"); }
    }

    public void pick(Item item){

        if (!itemExist(item)){
            System.out.println("I don't see that around here");
            return;
        }

        /* Add item to inventory if pass itemExist test */
        getInventory().add(item);
        System.out.println(getInventory());
        setInventory(getInventory());
    }

    public void attack(Monster monster){

        if (!monsterExist(monster)){
            System.out.println("I don't see that around here");
            return;
        }

        String monsterType = monster.getType();
        int potentialTakenDamage = getCurrentHp() - monster.getDamage() + getDefend();

        switch (monsterType) {
            case "ghost":
                boolean ghostFlag = ((GhostMonster) monster).playerIsEquipped(this);
                if (ghostFlag) {
                    monster.setHp(monster.getHp() - getDamage());

                    /* Monster retaliation */
                    if (monster.getHp() > 0) { setCurrentHp(potentialTakenDamage); }

                    System.out.println("Attacked " + monster.getName());
                    System.out.println(monster.getName() + " HP is: " + monster.getHp());
                    System.out.println("Your HP is: " + getCurrentHp() + "/" + getMaxHp());
                }
                break;
            case "normal":
                boolean normalFlag = ((NormalMonster) monster).playerIsEquipped(this);
                if (normalFlag) {
                    monster.setHp(monster.getHp() - getDamage());

                    /* Monster retaliation */
                    if (monster.getHp() > 0) { setCurrentHp(potentialTakenDamage); }

                    System.out.println("Attacked " + monster.getName());
                    System.out.println(monster.getName() + " HP is: " + monster.getHp());
                    System.out.println("Your HP is: " + getCurrentHp() + "/" + getMaxHp());
                }
                break;
        }
        postBattle(monster);
    }

    public void flee(Monster monster){

        if (!monsterExist(monster)){
            System.out.println("I don't think I need to run from anything");
            return;
        }

        monster.setHp(0);
        final Random random = new Random();
        int potentialDamage = monster.getDamage() * 5;

        if ( random.nextBoolean() ){
            /* Receive damage by chance */
            setCurrentHp(getCurrentHp() - potentialDamage);
        } postBattle(monster);
    }

    /* Look at function is implemented inside zorkRunner */

    public void lookAround(Map<GameMap.Coordination, ArrayList<Object>> thisLevel){

        GameMap.Coordination thisPosition = getCurrentPosition();
        ArrayList<Object> thisPositionItem = thisLevel.get(thisPosition);

        if (thisPositionItem.size() == 0){
            System.out.println("Doesn't look like there's much here");
            return;
        }

        System.out.print("There's something that looks like a ");
        for (Object i: thisPositionItem){
            if (i instanceof Monster){
                if (((Monster) i).getHp() <= 0){
                    System.out.print("Dead " + ((Monster) i).getName() + " and a ");
                    continue;
                }
                System.out.print(((Monster) i).getName() + " and a ");
            } else if (i instanceof Item){
                System.out.print(((Item) i).getName() + " and a ");
            }
        }
        System.out.print("over here.\n");
    }
}
