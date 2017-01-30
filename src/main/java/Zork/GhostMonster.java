package Zork;

import java.util.List;

/**
 * Created by Trung on 1/30/2017.
 */
class GhostMonster extends Monster {

    String isWeakTo;

    public GhostMonster(int hp, int damage, String description, String name, List<String> items, String isWeakTo){
        super(hp, damage, "ghost", description, name, items);
        this.isWeakTo = isWeakTo;
        
    }
}