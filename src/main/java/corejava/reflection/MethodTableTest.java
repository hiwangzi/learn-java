package corejava.reflection;

import java.lang.reflect.Method;

public class MethodTableTest {

    public static void main(String[] args) throws Exception {

        Method square = MethodTableTest.class.getDeclaredMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        printTable(1, 10, 5, square);
        System.out.println();
        printTable(1, 10, 10, sqrt);
    }

    private static double square(double x) {
        return x * x;
    }

    private static void printTable(double from, double to, int number, Method method) {
        System.out.println(method);
        double stepLength = (to - from) / (number - 1);
        for (double x = from; x <= to; x = x + stepLength) {
            try {
                Object result = method.invoke(null, x);
                System.out.println(x + " | " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
