package pl.przychodniagardno.przychodniab.exceptionHandler;

public class NewsNotFoundException extends RuntimeException {
    public NewsNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
