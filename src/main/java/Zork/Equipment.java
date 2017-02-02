package Zork;

/**
 * Created by Trung on 2/2/2017.
 */
public class Equipment extends Item{

    protected int defendPotential;
    protected int attackPotential;

    public void setDefendPotential(int defendPotential){ this.defendPotential = defendPotential; }

    public void setAttackPotential(int attackPotential){ this.attackPotential = attackPotential; }

    public int getDefendPotential(){ return this.defendPotential; }

    public int getDamagePotential(){ return this.attackPotential; }
}
