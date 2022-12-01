package ua.goit.hibernate.exceptions;

public class DeveloperAlreadyExistException extends RuntimeException {
    public DeveloperAlreadyExistException(String message) {
        super(message);
    }
}
