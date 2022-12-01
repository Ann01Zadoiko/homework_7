package ua.goit.hibernate.exceptions;

public class SkillAlreadyExistException extends RuntimeException {
    public SkillAlreadyExistException(String message) {
        super(message);
    }
}
