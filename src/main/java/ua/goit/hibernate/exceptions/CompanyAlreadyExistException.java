package ua.goit.hibernate.exceptions;

public class CompanyAlreadyExistException extends RuntimeException {
    public CompanyAlreadyExistException(String message) {
        super(message);
    }
}
