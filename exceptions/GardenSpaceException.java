package exercises.garden.exceptions;

public class GardenSpaceException extends Exception{
    public GardenSpaceException(int plantsRest){
        super("The garden is full. " + plantsRest + " plants cannot be planted.");
    }
}
