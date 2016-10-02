package ua.joit.java.spring.mvc.Exceptions;

public class ProhibitionException extends RuntimeException{

    public ProhibitionException(String message) {
        super(message);
    }
}