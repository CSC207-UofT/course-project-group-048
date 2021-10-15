package exceptions;

public class UserAlreadyRegisteredException extends LoginException {
    public UserAlreadyRegisteredException(String errorMessage) {
        super(errorMessage);
    }
}
