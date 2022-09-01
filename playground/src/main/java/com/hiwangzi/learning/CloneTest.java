package com.hiwangzi.learning;

import java.util.Objects;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student alice = new Student("Alice");
        System.out.println(alice);
        Student clone1 = alice.makeClone();
        System.out.println(clone1);
        Student clone2 = clone1.clone();
        System.out.println(clone2);
        System.out.println(clone1 == clone2);
        System.out.println(clone1.equals(clone2));
    }

    private static class Student implements Cloneable {
        private String name;

        Student(String aName) {
            this.name = aName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student makeClone() {
            try {
                return (Student) this.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        @Override
        protected Student clone() throws CloneNotSupportedException {
            return (Student) super.clone();
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return name.equals(student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}


