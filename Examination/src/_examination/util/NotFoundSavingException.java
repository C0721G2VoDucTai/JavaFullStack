package _examination.util;
import org.omg.CORBA.UserException;
public class NotFoundSavingException extends  Exception{
    public NotFoundSavingException()  {
    }
    public NotFoundSavingException(String reason) {
        super(reason);
    }
}
