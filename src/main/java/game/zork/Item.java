package game.zork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trung on 2/2/2017.
 */
public class Item {

    protected String type;
    protected String description;
    protected String name;

    @Override
    public boolean equals(Object item){

        boolean flag = false;

        if (item instanceof  Item){ flag = ((Item) item).getName() == this.getName(); }

        return flag;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 17 * hash + (this.getName() != null ? this.getName().hashCode() : 0);
        return hash;
    }

    /* All GETS methods */

    public String getType(){ return this.type; }

    public String getDescription(){ return this.description; }

    public String getName(){ return this.name; }


    /* All SETS methods */
    public void setName(String name){ this.name = name; }

    public void setDescription(String description){ this.description = description; }

    public void setType(String type){ this.type = type; }

}
