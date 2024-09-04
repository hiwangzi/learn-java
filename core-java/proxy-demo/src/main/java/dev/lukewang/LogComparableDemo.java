package dev.lukewang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class LogComparableDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogComparableDemo.class);

    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        // fill elements with proxies for the integers 1..1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            elements[i] = Proxy.newProxyInstance(
                    null,
                    new Class[]{Comparable.class},
                    new TraceHandler(value)
            );
        }

        // construct a random integer
        Integer key = new Random().nextInt(elements.length) + 1;

        // search for the key
        int result = Arrays.binarySearch(elements, key);

        // print match if found
        if (result >= 0) LOGGER.info("Found {}.", elements[result]);
    }
}