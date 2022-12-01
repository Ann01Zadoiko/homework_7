package ua.goit.hibernate.exceptions;

public class ProjectAlreadyExistException extends RuntimeException {
    public ProjectAlreadyExistException(String message) {
        super(message);
    }
}
