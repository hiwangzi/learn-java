package dev.lukewang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TraceHandler implements InvocationHandler {

    private final Logger logger = LoggerFactory.getLogger(TraceHandler.class);
    private final Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (logger.isInfoEnabled()) {
            String argsString = "";
            if (args != null) {
                argsString = Arrays.stream(args).map(Object::toString).collect(Collectors.joining(", "));
            }
            logger.info("{}.{}({})", target, method.getName(), argsString);
        }
        return method.invoke(target, args);
    }
}
