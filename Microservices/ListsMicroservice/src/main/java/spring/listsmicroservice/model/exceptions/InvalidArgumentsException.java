package spring.listsmicroservice.model.exceptions;

public class InvalidArgumentsException extends RuntimeException {

    public InvalidArgumentsException() {
        super("Invalid arguments exception! Please try again.");
    }
}
