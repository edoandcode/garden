package exercises.garden;

import exercises.garden.exceptions.HarvestDateException;
import exercises.garden.exceptions.SowingDateException;
import exercises.garden.exceptions.VegetableNameException;

import java.util.Date;

public class Vegetable {
    private final String name;
    private final Date sowingDate;
    private Date harvestDate;

    public Vegetable(String name, Date sowingDate, Date harvestDate) throws Exception {
        if(name.length() >= 2) this.name = name;
        else throw new VegetableNameException();
        if(sowingDate.after(new Date())) this.sowingDate = sowingDate;
        else throw new SowingDateException();
        if(harvestDate.after(this.sowingDate)) this.harvestDate = harvestDate;
        else throw new HarvestDateException();
    }

    public String getName() {
        return ""+name;
    }

    public Date getSowingDate() {
        return sowingDate;
    }

    public Date getHarvestDate() {
        return harvestDate;
    }


    public static Vegetable[] pushVegetableInList(Vegetable[] vegetables, Vegetable vegetable){
        Vegetable[] newVegetables = new Vegetable[vegetables.length + 1];
        for(int i = 0; i < vegetables.length; i++){
            newVegetables[i] = vegetables[i];
        }
        newVegetables[newVegetables.length-1] = vegetable;
        return newVegetables;
    }

    @Override
    public String toString(){
        return "\nName: " + getName() + "\nSown Date: " + getSowingDate() + "\nHarvestDate: " + getHarvestDate();
    }
}
