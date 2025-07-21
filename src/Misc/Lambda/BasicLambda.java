package Misc.Lambda;

interface LambdaExample {
    String someMethod();
}

public class BasicLambda {

    public static void main(String[] args) {
        LambdaExample x = () -> {
            return "this is sparta.";
        };
        System.out.println(x.someMethod());
    }

}
