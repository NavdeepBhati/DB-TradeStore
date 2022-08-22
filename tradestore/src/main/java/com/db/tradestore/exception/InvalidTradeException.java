package com.db.tradestore.exception;

public class InvalidTradeException extends RuntimeException {

	private static final long serialVersionUID = 14000000L;

    public InvalidTradeException(final String id) {
        super("The trade exception with id : " + id + " is invalid.");
    }

}
