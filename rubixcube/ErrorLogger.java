package Rubix;

/**
 * Created by Robert on 11/25/2016.
 */
public class ErrorLogger extends RuntimeException{
    public ErrorLogger (String message){
        System.err.print(message);
        throw new RuntimeException(message);
    }
}
