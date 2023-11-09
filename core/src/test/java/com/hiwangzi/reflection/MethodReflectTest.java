package com.hiwangzi.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class MethodReflectTest {
    @Test
    void testMethodReflect() throws Exception {

        Method square = MethodReflectTest.class.getDeclaredMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        print(1, 10, 5, square);
        System.out.println();
        print(1, 10, 10, sqrt);
    }

    private static double square(double x) {
        return x * x;
    }

    private static void print(double from, double to, int count, Method method) {
        System.out.println(method);
        double stepLength = (to - from) / (count - 1);
        for (double x = from; x <= to; x = x + stepLength) {
            try {
                // ‼️ 重点 ⬇️ method.invoke(obj, args...)
                Object result = method.invoke(null, x);
                // make result human-readable
                System.out.print(x + "\t");
                if (String.valueOf(x).length() < 4) System.out.print("\t");
                System.out.print(result + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
