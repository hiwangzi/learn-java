package corejava.reflection;

import corejava.general.Employee;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class CopyOfTest {

    public static void main(String[] args) {
        Employee xiaoming = new Employee("xiaoming");
        Employee[] employees = new Employee[10];
        employees[0] = xiaoming;
        // debug print
        Object[] objects = employees;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null)
                System.out.println(((Employee) objects[i]).getName());
        }

        Employee[] employees1 = (Employee[]) goodCopyOf(objects, 3);
        // debug print
        System.out.println(Arrays.toString(employees1));

        // ------------
        // 测试基本类型数组
        int[] intArray = new int[]{0, 1, 2};
        System.out.println(Arrays.toString(intArray));
        int[] intArray1 = (int[]) goodCopyOf(intArray, 10);
        System.out.println(Arrays.toString(intArray1));
    }

    private static Object goodCopyOf(Object array, int newLength) {
        Objects.requireNonNull(array);
        Class clazz = array.getClass();
        if (clazz.isArray()) {
            Class componentTypeClazz = clazz.getComponentType();
            int length = Array.getLength(array);
            Object newArray = Array.newInstance(componentTypeClazz, newLength);
            System.arraycopy(array, 0, newArray, 0, Math.min(length, newLength));
            return newArray;
        } else {
            throw new IllegalArgumentException("First parameter should be an array.");
        }
    }
}
