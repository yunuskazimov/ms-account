package az.bank.account.msaccount.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Locale;

public enum CurrencyEnum implements Serializable {
    AZN, USD, RUB, EUR;

    @JsonValue
    public String toLower() {
        return this.toString().toLowerCase(Locale.ENGLISH);
    }
}
