package c02oop.javabase;

public class RecordDemo {
    public static void main(String[] args) {
        Employee zhangsan = new Employee("张三", 0, "男", 10000.0);
        Employee lisi = Employee.of("李四", 20, "女");
        System.out.println(zhangsan);
        System.out.println(lisi);
    }
}

record Employee(
        String name,
        int age,
        String gender,
        double salary
) {
    public Employee { // Compact Constructor
        if (age < 0) {
            throw new IllegalArgumentException("年龄不能小于0");
        }
    }

    public static Employee of(String name, int age, String gender) {
        return new Employee(name, age, gender, 0.0);
    }
}