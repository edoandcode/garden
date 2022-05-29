package exercises.garden.exceptions;

public class SowingDateException extends Exception{
    public SowingDateException(){
        super("Sowing date is before today");
    }
}
