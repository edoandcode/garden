package exercises.garden.exceptions;

public class BiodiversityException extends Exception{
    public BiodiversityException(){
        super("Too many plants types in garden.");
    }
}
