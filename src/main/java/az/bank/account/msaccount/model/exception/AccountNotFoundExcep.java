package az.bank.account.msaccount.model.exception;

public class AccountNotFoundExcep extends RuntimeException {
    public AccountNotFoundExcep(String message){
        super(message);
    }
}
