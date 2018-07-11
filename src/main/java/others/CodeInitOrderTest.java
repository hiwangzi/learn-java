package others;

public class CodeInitOrderTest {

    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student();

        System.out.println(student1 == student2);

        System.out.println(student1.getId());
        System.out.println(student2.getId());

    }
}

class Student {
    private String hello = "world";
    private String id = assignId();

    public String getId() {
        return id;
    }

    private static int nextId = justSetNextId();

    private static String assignId() {
        System.out.println("assignId");
        return String.valueOf(nextId++);
    }

    private static int justSetNextId() {
        System.out.println("justSetNextId");
        return 3;
    }

    static {
        System.out.println(nextId);
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
        this.id = "100";
    }

    public Student() {
        this.id = "200";
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
