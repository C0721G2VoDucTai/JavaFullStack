package voductai.book_borrow_app.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import java.util.Arrays;

@Aspect
@Component
public class Log {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @After("execution(public * voductai.book_borrow_app.controller.BookController.*(..))")
    public void logAfterMethodCall(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] Have a change book in library", methodName, args));
    }
    
    
    
    
    @AfterThrowing(pointcut = "execution(public * voductai.book_borrow_app.controller.BookController.*(..))",
            throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] Have a error: %s.%s%s: %s", className, method, args, e.getMessage()));
    }

}
