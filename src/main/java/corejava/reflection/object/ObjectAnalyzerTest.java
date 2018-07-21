package corejava.reflection.object;

import corejava.general.Employee;
import corejava.general.Identification;

public class ObjectAnalyzerTest {

    public static void main(String[] args) {
        ObjectAnalyzer objectAnalyzer = new ObjectAnalyzer();

        // 分析数组
//         int[] a = new int[]{0, 1, 2, 3, 4, 5};
//         System.out.println(objectAnalyzer.toString(a));

        // 分析对象（无限递归示例）
        Employee xiaoming = new Employee("xiaoming");
        Identification identification = new Identification("007");
        xiaoming.setIdentification(identification);
        identification.setEmployee(xiaoming);
        System.out.println(objectAnalyzer.toString(xiaoming));

        // 分析ArrayList
//        ArrayList<Integer> squares = new ArrayList<>(3);
//        for (int i = 1; i <= 3; i++) {
//            squares.add(i * i);
//        }
//        System.out.println(objectAnalyzer.toString(squares));
    }
}
