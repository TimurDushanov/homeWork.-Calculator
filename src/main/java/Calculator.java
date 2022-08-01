import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> x / y;

    UnaryOperator<Integer> pow = x -> x * x;

//    public int abs (int x) {
//        x =  x > 0 ? x : x * -1;
//        return x;
//    }

    BinaryOperator<Integer> abs = (x, y) -> x > y ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;

}

class Main {
    public static void main(String[] args) {
        Calculator calculator = Calculator.instance.get();
        int a = calculator.plus.apply(1, 2);
        int b = calculator.minus.apply(1, 1);
        int c = calculator.devide.apply(a, b);

        calculator.println.accept(c);
    }
}
// Тернарный оператор был некорректно реализован, так как принимал в параметры только один параметр,
// для переменной abs я применил бинарный функциональный оператор, который сравнивает x и y.
// но даже в таком случае код не будет компилиться, так как этот метод не вызывается в psvm