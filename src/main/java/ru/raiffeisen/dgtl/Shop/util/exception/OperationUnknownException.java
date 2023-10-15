package ru.raiffeisen.dgtl.Shop.util.exception;

public class OperationUnknownException extends RuntimeException {
    public OperationUnknownException(String operation) {
        super(operation + " - is unknown operation");
    }
}
