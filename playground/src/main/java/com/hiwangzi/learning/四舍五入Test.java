package com.hiwangzi.learning;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SuppressWarnings("NonAsciiCharacters")
public class 四舍五入Test {
    public static void main(String[] args) {
        long cent1 = new BigDecimal(100L)
                .multiply(new BigDecimal("0.995"))
                .setScale(0, RoundingMode.HALF_UP)
                .longValue();

        long cent2 = new BigDecimal(123L)
                .divide(new BigDecimal("0.8"), 0, RoundingMode.HALF_UP)
                .longValue();

        long cent3 = new BigDecimal("100.999")
                .multiply(new BigDecimal("100"))
                .setScale(0, RoundingMode.HALF_UP)
                .longValue();

        System.out.println("cent1(预期100): " + cent1 + " " + (100L == cent1));
        System.out.println("cent2(预期154): " + cent2 + " " + (154L == cent2));
        System.out.println("cent3(预期10100): " + cent3 + " " + (10100L == cent3));
    }
}
