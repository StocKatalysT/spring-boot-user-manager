package be.stocka.springbootusermanager.ws;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Logger.class);

    @Before(value = "execution(public java.util.List<be.stocka.springbootusermanager.beans.User> getUsers())")
    public void logBeforeGetUsers() {
        LOGGER.info("Before getUsers called");
    }

    @After(value = "execution(public java.util.List<be.stocka.springbootusermanager.beans.User> getUsers())")
    public void logAfterGetUsers() {
        LOGGER.info("After getUsers called");
    }
}
