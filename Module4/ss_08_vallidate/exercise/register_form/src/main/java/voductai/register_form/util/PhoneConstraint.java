package voductai.register_form.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneConstraint {
    String message() default "Phone is wrong format";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

}
