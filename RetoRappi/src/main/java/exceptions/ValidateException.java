package exceptions;

public class ValidateException extends AssertionError {
    public static final String GET_USER_ERROR = "The user consult  was not success";
    public static final String REGISTER_USER_ERROR = "The user register  was not success";
    public static final String DELETE_USER = "The user delete  was not success";

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }
}
