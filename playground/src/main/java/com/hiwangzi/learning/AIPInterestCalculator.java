package com.hiwangzi.learning;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 定投收益的计算（递归、循环）
 */
public class AIPInterestCalculator {
    public static void main(String[] args) {
        BigDecimal totalRecursion = investRecursion(12, new BigDecimal(1000), new BigDecimal(0.05));
        System.out.println(totalRecursion);
        BigDecimal totalLoop = investLoop(12, new BigDecimal(1000), new BigDecimal(0.05));
        System.out.println(totalLoop);
    }

    //<editor-fold desc="递归方式">
    private static BigDecimal investRecursion(int month, BigDecimal money, BigDecimal rate) {
        BigDecimal monthRate = rate.divide(new BigDecimal(12), 10, RoundingMode.HALF_UP);
        return investRecursionMonthRate(month, money, monthRate);
    }

    private static BigDecimal investRecursionMonthRate(int month, BigDecimal money, BigDecimal monthRate) {
        if (month == 0) {
            return new BigDecimal(0);
        }

        BigDecimal total = money.add(investRecursionMonthRate(month - 1, money, monthRate));
        return total.add(total.multiply(monthRate));
    }
    //</editor-fold>

    /* 循环方式 begin */
    //<editor-fold desc="循环方式">
    private static BigDecimal investLoop(int month, BigDecimal money, BigDecimal rate) {
        BigDecimal monthRate = rate.divide(new BigDecimal(12), 10, RoundingMode.HALF_UP);
        return investLoopMonthRate(month, money, monthRate);
    }

    private static BigDecimal investLoopMonthRate(int month, BigDecimal money, BigDecimal monthRate) {
        BigDecimal total = new BigDecimal(0);
        for (int i = 0; i < month; i++) {
            total = total.add(money);
            total = total.add(total.multiply(monthRate));
        }
        return total;
    }
    //</editor-fold>
}
