package corejava.reflection.object;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * 将当前对象转换为包含类名及字段名称、值的字符串
     */
    public String toString(Object obj) {

        // 情况一：null
        if (obj == null) {
            return "null";
        }
        // 避免无限递归
        if (visited.contains(obj)) {
            return "...";
        }
        visited.add(obj);
        // 情况二：数组类型
        Class clazz = obj.getClass();
        if (clazz.isArray()) {
            String result = clazz.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) result += ", ";
                Object value = Array.get(obj, i);
                if (clazz.getComponentType().isPrimitive()) result += value;
                else result += toString(value);
            }
            return result + "}";
        }
        // 情况三：对象
        String result = clazz.getName() + "[";
        Field[] fields = clazz.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        for (Field f : fields) {
            if (!Modifier.isStatic(f.getModifiers())) {
                if (!result.endsWith("[")) result += ", ";
                result += f.getName() + " = ";
                try {
                    Class t = f.getType();
                    Object value = f.get(obj);
                    if (t.isPrimitive()) result += value;
                    else result += toString(value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result + "]";
    }

    public static void main(String[] args) {

    }
}