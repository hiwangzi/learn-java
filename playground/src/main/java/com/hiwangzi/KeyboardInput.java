package com.hiwangzi;

import java.io.IOException;
import java.util.Scanner;

public class KeyboardInput {

    public static void main(String[] args) throws IOException {
        var in = System.in;
        var scanner = new Scanner(in);
        while (true) {
            System.out.println(scanner.nextLine());
        }
    }
}
