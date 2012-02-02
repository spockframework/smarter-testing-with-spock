package state;

import java.math.BigDecimal;

public class NegativeAmountWithdrawnException extends RuntimeException {
    private final BigDecimal amount;

    public NegativeAmountWithdrawnException(BigDecimal amount) {
        super("cannot withdraw " + amount);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
