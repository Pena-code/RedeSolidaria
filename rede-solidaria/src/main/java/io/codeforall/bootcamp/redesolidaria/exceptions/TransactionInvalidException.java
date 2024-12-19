package io.codeforall.bootcamp.redesolidaria.exceptions;

import io.codeforall.bootcamp.redesolidaria.errors.ErrorMessage;

/**
 * Thrown to indicate that the transaction was not valid
 */
public class TransactionInvalidException extends JavaBankException {

    /**
     * @see JavaBankException#JavaBankException(String)
     */
    public TransactionInvalidException() {
        super(ErrorMessage.TRANSACTION_INVALID);
    }
}
