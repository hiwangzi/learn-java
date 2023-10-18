package com.hiwangzi.learning.inheritance.interfaze;

public class Instanze implements Eatable, Runnable {
    @Override
    public void eat() {

    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        Instanze instanze = new Instanze();
        instanze.liveDefault();
    }

    @Override
    public void live() {

    }
}
