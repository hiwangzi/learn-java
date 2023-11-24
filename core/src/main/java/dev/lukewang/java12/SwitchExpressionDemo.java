package dev.lukewang.java12;

public class SwitchExpressionDemo {
    public static void main(String[] args) {
        switchBeforeJava12();

        int num = 2;
        String result = switch (num) {
            case 1 -> "one";
            case 2 -> "two";
            default -> {
                // 可以在 {} 中执行多条语句
                yield  "other";
            }
        };
        System.out.println(result);
    }

    public static void switchBeforeJava12() {
        int num = 2;
        String result;
        switch (num) {
            case 1:
                result = "one";
                break;
            case 2:
                result = "two";
                break;
            default:
                result = "other";
        }
        System.out.println(result);
    }
}
