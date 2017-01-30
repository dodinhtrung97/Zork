package Zork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trung on 1/30/2017.
 */
public class Monster {

    protected int hp;
    protected int damage;
    protected String type;
    protected String description;
    protected String name;
    protected List<String> items = new ArrayList<>();

    protected Monster(int hp, int damage, String type, String description, String name, List<String> items){
        this.hp = hp;
        this.damage = damage;
        this.type = type;
        this.description = description;
        this.name = name;
        this.items = items;
    }
}

