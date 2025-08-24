package Stream;

import java.util.function.Predicate;

public class pradicat {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation sub = (a, b) -> a - b;
        System.out.println("Result : " + add.operation(10, 20));

       // Predicate --> Functional Interface(boolean valued function)
        Predicate<Integer> isOdd = x -> x % 3 == 0;

    }
}

interface MathOperation {
    int operation(int a, int b);
}