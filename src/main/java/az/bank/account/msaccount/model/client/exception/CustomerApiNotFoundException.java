package az.bank.account.msaccount.model.client.exception;

public class CustomerApiNotFoundException extends RuntimeException {
    public CustomerApiNotFoundException(String message) {
        super(message);
    }
}
