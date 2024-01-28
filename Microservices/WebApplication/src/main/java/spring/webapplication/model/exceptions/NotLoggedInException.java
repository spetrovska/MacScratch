package spring.webapplication.model.exceptions;

public class NotLoggedInException extends RuntimeException{
    public NotLoggedInException() {super("First you must login!");
    }
}
