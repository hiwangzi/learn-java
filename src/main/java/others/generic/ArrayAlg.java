package others.generic;

public class ArrayAlg {

    public static <T> Object getMiddle(T... a) {
        return a[a.length / 2];
    }

    public static void main(String[] args) {
        System.out.println(getMiddle(1, 2, 3, 4));
    }
}