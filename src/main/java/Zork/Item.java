package Zork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trung on 2/2/2017.
 */
public class Item {

    protected String type;
    protected String description;
    protected String name;

    ArrayList<Item> allItems = new ArrayList<>();

    /* All GETS methods */

    public String getType(){ return this.type; }

    public String getDescription(){ return this.description; }

    public String getName(){ return this.name; }


    /* All SETS methods */
    public void setName(String name){ this.name = name; }

    public void setDescription(String description){ this.description = description; }

    public void setType(String type){ this.type = type; }

}
