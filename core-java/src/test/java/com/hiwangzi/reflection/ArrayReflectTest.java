package com.hiwangzi.reflection;

import com.hiwangzi.reflection.bean.Employee;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class ArrayReflectTest {
    @Test
    void goodCopyOfObject() {
        Employee tom = new Employee("Tom");
        Employee[] employees = new Employee[10];
        employees[0] = tom;

        // 转换为 Object[] 后，再将其中 item 转换为 Employee
        Object[] objects = employees;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null)
                System.out.println(((Employee) objects[i]).getName());
        }

        // 打印复制出的对象数组
        Employee[] employeesCopy = (Employee[]) goodCopyOf(objects, 3);
        System.out.println(Arrays.toString(employeesCopy));
    }

    /**
     * 测试基本类型数组
     */
    @Test
    void goodCopyOfIntArray() {
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

    private static Object[] badCopyOf(Object[] a, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }
}
