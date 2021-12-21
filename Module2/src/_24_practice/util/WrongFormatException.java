package _24_practice.util;
import org.omg.CORBA.UserException;
public class WrongFormatException extends Exception {
    public WrongFormatException()  {
    }
    public WrongFormatException(String reason) {
        super(reason);
    }
}
