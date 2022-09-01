package com.hiwangzi.learning;

import javax.swing.*;

public class SwingTimerTest {
    public static void main(String[] args) {
        Timer t = new Timer(1000, e -> {
            System.out.println("hello\n---");
        });
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
