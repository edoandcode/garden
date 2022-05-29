package exercises.garden.exceptions;

public class SurfaceException extends Exception{
    public SurfaceException(int minGardenSurface){
        super("The surface provided is too little. You need at least of "+minGardenSurface+" for creating a garden.");
    }
}
