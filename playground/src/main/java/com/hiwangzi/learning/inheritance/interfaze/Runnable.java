package com.hiwangzi.learning.inheritance.interfaze;

public interface Runnable extends Livable {
    void run();

    @Override
    default void liveDefault() {
        System.out.println("Runnable - liveDefault");
    }
}
