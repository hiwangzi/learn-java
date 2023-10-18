package com.hiwangzi.learning.inheritance.interfaze;

public interface Livable {
    void live();

    default void liveDefault() {
        System.out.println("Livable - liveDefault");
    }
}
