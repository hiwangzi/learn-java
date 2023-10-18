package com.hiwangzi.learning.pattern.singleton;

public class LazySingleton {

    private LazySingleton() {
    }

    // 测试
    private static LazySingleton instance = null;

    public static LazySingleton getInstance() {
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }
}
