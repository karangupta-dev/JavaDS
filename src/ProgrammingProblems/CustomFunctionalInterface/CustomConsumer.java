package ProgrammingProblems.CustomFunctionalInterface;

@FunctionalInterface
interface MyConsumer<T> {
    void accept(T t);   // abstract method

    // default method (optional)
    default MyConsumer<T> andThen(MyConsumer<T> after) {
        return t -> { this.accept(t); after.accept(t); };
    }
}


public class CustomConsumer {

    public static void main(String[] args) {
        MyConsumer<String> printer = msg -> System.out.println("Message: " + msg);
        MyConsumer<String> upper = msg -> System.out.println("Upper: " + msg.toUpperCase());

        // Single consumer
        printer.accept("hello");
        // Chained consumers
        printer.andThen(upper).accept("world");
    }

}
