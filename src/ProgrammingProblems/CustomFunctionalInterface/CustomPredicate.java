package ProgrammingProblems.CustomFunctionalInterface;

@FunctionalInterface
interface MyPredicate<T> {
    boolean test(T t);   // abstract method

    // default method (optional)
    default MyPredicate<T> and(MyPredicate<T> other) {
        return t -> this.test(t) && other.test(t);
    }
}

public class CustomPredicate {
    public static void main(String[] args) {
        MyPredicate<Integer> isEven = n -> n % 2 == 0;
        MyPredicate<Integer> isPositive = n -> n > 0;

        System.out.println(isEven.test(4));  // true
        System.out.println(isEven.and(isPositive).test(-2)); // false
    }
}
