package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.awt.desktop.SystemEventListener;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    public Object excute(ProceedingJoinPoint jointPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + jointPoint.toString());
        try {
            Object result = jointPoint.proceed();
            return result;
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + jointPoint.toString()
                    + " " + timeMs + "Ms");
        }
    }
}
