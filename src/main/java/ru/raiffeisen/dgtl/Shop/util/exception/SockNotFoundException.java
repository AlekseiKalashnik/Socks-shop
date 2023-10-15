package ru.raiffeisen.dgtl.Shop.util.exception;

public class SockNotFoundException extends RuntimeException{
    public SockNotFoundException(String color, Integer cottonPart) {
        super("Sock with " + color + " color and cotton part = " +
                cottonPart + " is absent in DB");
    }
}
