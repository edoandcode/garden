package exercises.garden.exceptions;

public class HarvestDateException extends Exception{
    public HarvestDateException(){
        super("Harvest date can't be before the sowing date.");
    }
}
