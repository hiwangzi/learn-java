package com.hiwangzi;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {
    public static void main(String[] args) {
        var result = NumberFormat.getCurrencyInstance(Locale.US).format(1839174.1243);
        System.out.println(result);
        System.out.println(result.split(",")[2]);

        var a = Integer.parseInt(args[0]);
        if (a > 1) {
            return;
        }
        System.out.println();
    }
}
