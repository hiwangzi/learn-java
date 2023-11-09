package com.hiwangzi.reflection.analyzer;

import com.hiwangzi.reflection.analyzer.ObjectAnalyzer;
import com.hiwangzi.reflection.bean.Employee;
import com.hiwangzi.reflection.bean.Identification;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ObjectAnalyzerTest {

    private final ObjectAnalyzer objectAnalyzer = new ObjectAnalyzer();

    /**
     * 分析数组
     */
    @Test
    void analyzeArray() {
        int[] a = new int[]{0, 1, 2, 3, 4, 5};
        System.out.println(objectAnalyzer.toString(a));
    }

    /**
     * 分析对象（无限递归示例）
     */
    @Test
    void analyzeObject() {
        Employee xiaoming = new Employee("xiaoming");
        Identification identification = new Identification("007");
        xiaoming.setIdentification(identification);
        identification.setEmployee(xiaoming);
        System.out.println(objectAnalyzer.toString(xiaoming));
    }

    /**
     * 分析ArrayList
     */
    @Test
    void analyzeArrayList() {
        ArrayList<Integer> squares = new ArrayList<>(3);
        for (int i = 1; i <= 3; i++) {
            squares.add(i * i);
        }
        System.out.println(objectAnalyzer.toString(squares));
    }
}
