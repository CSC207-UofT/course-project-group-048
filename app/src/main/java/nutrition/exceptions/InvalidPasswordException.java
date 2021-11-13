package nutrition.exceptions;


public class InvalidPasswordException extends LoginException {
    public InvalidPasswordException(String errorMessage) {
        super(errorMessage);
    }
}