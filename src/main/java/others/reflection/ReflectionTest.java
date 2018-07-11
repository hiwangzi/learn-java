package others.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {
    public static void main(String[] args) {
        String className = "java.lang.Double";

        try {
            Class cl = Class.forName(className);
            Class superCl = cl.getSuperclass();
            String clModifier = Modifier.toString(cl.getModifiers());
            System.out.println(clModifier + " " + cl.getName() + " extends " + superCl.getName());
            System.out.println("{");

            printConstructors(cl);
            System.out.println();

            printMethods(cl);
            System.out.println();

            printFields(cl);

            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getConstructors();
        for (Constructor constructor : constructors) {
            String constructorModifier = Modifier.toString(constructor.getModifiers());
            System.out.print(constructorModifier + " " + constructor.getName() + "(");
            String parameterTypeStr = "";
            for (Class parameterType : constructor.getParameterTypes()) {
                parameterTypeStr = parameterType.getName() + ", ";
            }
            if (constructor.getParameterTypes().length != 0) {
                parameterTypeStr = parameterTypeStr.substring(0, parameterTypeStr.length() - 2);
            }
            System.out.print(parameterTypeStr + ")\n");
        }
    }

    public static void printMethods(Class cl) {
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            String methodModifier = Modifier.toString(method.getModifiers());
            System.out.print(methodModifier + " " + method.getName() + "(");
            String parameterTypeStr = "";
            for (Class parameterType : method.getParameterTypes()) {
                parameterTypeStr = parameterType.getName() + ", ";
            }
            if (method.getParameterTypes().length != 0) {
                parameterTypeStr = parameterTypeStr.substring(0, parameterTypeStr.length() - 2);
            }
            System.out.print(parameterTypeStr + ")\n");
        }
    }

    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            String fieldModifier = Modifier.toString(field.getModifiers());
            System.out.println(fieldModifier + " " + field.getName());
        }
    }
}
