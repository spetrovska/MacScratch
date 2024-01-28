package spring.listsmicroservice.model.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException {
    public InvalidUsernameOrPasswordException() {super("Invalid Username Or Password! Please try again.");
    }
}

