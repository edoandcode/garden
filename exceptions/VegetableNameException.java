package exercises.garden.exceptions;

public class VegetableNameException extends Exception{
    public VegetableNameException(){
        super("Vegetable name must be a String with at least 2 character");
    }
}
