package exercises.garden.exceptions;

import exercises.garden.Vegetable;

public class AlreadySownException extends Exception{
    public AlreadySownException(Vegetable vegetable){
        super(vegetable.getName() + " is already sown in this garden! Please sow another plant.");
    }
}
