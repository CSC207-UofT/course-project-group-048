package nutrition.exceptions;

public class UsernameNotFoundException extends LoginException {
    public UsernameNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
