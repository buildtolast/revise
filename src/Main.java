
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        IntStreamDemo.main(null);
        IntStreamDemo2.main(null);
    }

}


class IntStreamDemo {

    public static void main(String[] args) {
        //Integer[] m = IntStream.range(0,9).toArray(); // wrong
        //Integer[] n = IntStream.range(0,9).toArray(); // wrong

        int[] m = IntStream.range(0, 9).toArray();
        int[] n = IntStream.rangeClosed(0, 9).toArray();


        print(m); // 0..8
        print(n); // 0..9

    }

    static void print(int[] m) {
        for (int i : m) {
            System.out.println(i); // 0...8
        }
    }

}

class IntStreamDemo2 {

    public static void main(String[] args) {

        IntConsumer y = value -> {
            System.out.println(value); };
        IntStream peek = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8).peek(y);
        int[] array = peek.toArray();
        print(array);

    }

    static void print(int[] m) {
        for (int i : m) {
            System.out.println(i); // 0...8
        }
    }

}