package utils;

import org.omg.CORBA.UserException;

public class WrongFormatException extends UserException {
    public WrongFormatException() {
    }
    public WrongFormatException(String reason) {
        super(reason);
    }
}
