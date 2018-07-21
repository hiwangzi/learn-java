package corejava.reflection.clazz;

import java.lang.reflect.Modifier;

public class ClassAnalyzerTest {
    public static void main(String[] args) {
        String className = "java.lang.Double";

        try {
            Class cl = Class.forName(className);
            Class superCl = cl.getSuperclass();
            String clModifier = Modifier.toString(cl.getModifiers());
            System.out.println(clModifier + " " + cl.getName() + " extends " + superCl.getName() + " {");

            ClassAnalyzer.printConstructors(cl);
            System.out.println();

            ClassAnalyzer.printMethods(cl);
            System.out.println();

            ClassAnalyzer.printFields(cl);

            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
