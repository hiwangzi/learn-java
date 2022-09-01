package com.hiwangzi.learning;

import java.util.Objects;

public class CodeInitOrderTest {
    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println("\n-------\n");
        Student student2 = new Student();

        System.out.println("\n-------\n");
        System.out.println(student1.equals(student2));
        System.out.println(student1.getId());
        System.out.println(student2.getId());

    }

    private static class Student {
        // 顺序1️⃣：静态属性❗️多个实例只执行一次
        private static int nextId = justSetNextId();

        private static int justSetNextId() {
            System.out.println("为静态属性赋值的静态方法：justSetNextId()");
            return 0;
        }

        // 顺序2️⃣：静态代码块❗️多个实例只执行一次
        static {
            System.out.println("静态代码块 - " + nextId);
        }

        // 顺序3️⃣：属性
        private final String role = "student";
        private String id = assignId();

        private String assignId() {
            System.out.println("为属性赋值的方法：assignId()");
            return String.valueOf(nextId++);
        }

        // 顺序4️⃣：构造代码块
        {
            System.out.println("构造代码块 - " + nextId + " - " + this.id);
            this.id = "100";
        }

        // 顺序5️⃣：构造方法
        public Student() {
            System.out.println("构造方法 - " + nextId + " - " + this.id);
            this.id = "200";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return role.equals(student.role) && id.equals(student.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(role, id);
        }

        public String getId() {
            return id;
        }
    }
}


