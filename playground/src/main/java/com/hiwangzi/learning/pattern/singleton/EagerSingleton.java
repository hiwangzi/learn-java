package com.hiwangzi.learning.pattern.singleton;

public class EagerSingleton {
    private EagerSingleton() {
    }

    private final static EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return instance;
    }
}
