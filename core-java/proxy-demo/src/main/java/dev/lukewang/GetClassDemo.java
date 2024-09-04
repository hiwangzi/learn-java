package dev.lukewang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

public class GetClassDemo {
    private static final Logger log = LoggerFactory.getLogger(GetClassDemo.class);

    public static void main(String[] args) {
        Integer value = 10086;
        Object p = Proxy.newProxyInstance(
                null,
                new Class[]{Comparable.class},
                new TraceHandler(value)
        );
        log.info("value.getClass(): {}", p.getClass()); // class jdk.proxy1.$Proxy0
        log.info("Proxy.isProxyClass(value.getClass()): {}", Proxy.isProxyClass(p.getClass())); // true
    }
}
