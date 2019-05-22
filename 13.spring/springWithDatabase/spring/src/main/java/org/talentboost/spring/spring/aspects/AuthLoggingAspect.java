package org.talentboost.spring.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AuthLoggingAspect {
    private static Logger logger = Logger.getLogger(AuthLoggingAspect.class.toString());

    // Task 3: Add an advice to log a message every time someone is authenticated.
    //			- Annotate this class to be used as an aspect.
    //			- Create a method to be advised to AccountManager's authenticate(..)
    //
    //		EASY MODE: Enable AOP in the current *config.xml file.
    //			- Define a bean for this aspect
    //			- Enable aspectj-autoproxy and import the bean in it.
    //
    //		HACKER MODE: Use a separate config file for aspects.
    //			- Create the new xml in the aspects package.
    //			- Import the new xml in the old xml.
    //			- Do the steps form the EASY MODE.
    @AfterReturning("execution(* org.talentboost.spring.spring.impl.AccountManager.*(..))")
    public void message() {
        System.out.println("Hi");
    }
}
