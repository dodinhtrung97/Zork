package game.zork;

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
    protected Item items;

    @Override
    public boolean equals(Object monster){

        boolean flag = false;

        if (monster instanceof  Monster){ flag = ((Monster) monster).getName() == this.getName(); }

        return flag;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 17 * hash + (this.getName() != null ? this.getName().hashCode() : 0);
        return hash;
    }

    /* All GETS methods */
    public int getHp(){ return this.hp; }

    public int getDamage(){ return this.damage; }

    public String getType(){ return this.type; }

    public String getDescription(){ return this.description; }

    public String getName(){ return this.name; }

    public Item getItem(){ return this.items; }


    /* All SETS methods */
    public void setName(String name){ this.name = name; }

    public void setItems(Item items){ this.items = items; }

    public void setHp(int hp){ this.hp = hp; }

    public void setDamage(int damage){ this.damage = damage; }

    public void setDescription(String description){ this.description = description; }

    public void setType(String type){ this.type = type; }

}

