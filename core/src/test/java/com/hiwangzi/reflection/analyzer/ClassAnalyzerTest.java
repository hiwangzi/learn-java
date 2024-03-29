package com.hiwangzi.reflection.analyzer;

import com.hiwangzi.reflection.analyzer.ClassAnalyzer;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

public class ClassAnalyzerTest {
    private final ClassAnalyzer classAnalyzer = new ClassAnalyzer();

    @Test
    void analyzeDouble() {
        String className = "java.lang.Double";
        try {
            Class cl = Class.forName(className);
            Class superCl = cl.getSuperclass();
            String clModifier = Modifier.toString(cl.getModifiers());
            System.out.println(clModifier + " " + cl.getName() + " extends " + superCl.getName() + " {");
            classAnalyzer.printConstructors(cl);
            System.out.println();
            classAnalyzer.printMethods(cl);
            System.out.println();
            classAnalyzer.printFields(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
