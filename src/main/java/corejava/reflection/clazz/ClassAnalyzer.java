package corejava.reflection.clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassAnalyzer {

    public void printConstructors(Class cl) {
        Constructor[] constructors = cl.getConstructors();
        for (Constructor constructor : constructors) {
            String constructorModifier = Modifier.toString(constructor.getModifiers());
            System.out.print("    " + constructorModifier + " " + constructor.getName() + "(");
            String parameterTypeStr = "";
            for (Class parameterType : constructor.getParameterTypes()) {
                parameterTypeStr = parameterType.getName() + ", ";
            }
            if (constructor.getParameterTypes().length != 0) {
                parameterTypeStr = parameterTypeStr.substring(0, parameterTypeStr.length() - 2);
            }
            System.out.print(parameterTypeStr + ")");
            System.out.print(";\n");
        }
    }

    public void printMethods(Class cl) {
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            String methodModifier = Modifier.toString(method.getModifiers());
            System.out.print("    " + methodModifier + " " + method.getName() + "(");
            String parameterTypeStr = "";
            for (Class parameterType : method.getParameterTypes()) {
                parameterTypeStr = parameterType.getName() + ", ";
            }
            if (method.getParameterTypes().length != 0) {
                parameterTypeStr = parameterTypeStr.substring(0, parameterTypeStr.length() - 2);
            }
            System.out.print(parameterTypeStr + ")");
            System.out.print(";\n");
        }
    }

    public void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            String fieldModifier = Modifier.toString(field.getModifiers());
            System.out.println("    " + fieldModifier + " " + field.getName() + ";");
        }
    }
}
