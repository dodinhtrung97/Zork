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

    /* All GETS methods */
    public int getHp(){ return this.hp; }

    public int getDamage(){ return this.damage; }

    public String getType(){ return this.type; }

    public String getDescription(){ return this.description; }

    public String getName(){ return this.name; }

    public List<String> getItem(){ return this.items; }


    /* All SETS methods */
    public void setItems(ArrayList<String> items){ this.items = items; }

    public void setHp(int hp){ this.hp = hp; }

    public void setName(String name){ this.name = name; }

    public void setDescription(String description){ this.description = description; }

    public void setType(String type){ this.type = type; }

    public void setDamage(int damage){ this.damage = damage; }

}

