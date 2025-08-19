package ProgrammingProblems.CustomFunctionalInterface;

@FunctionalInterface
interface ICustomPredicateCopy<T> {
    public boolean isValid(int a);

    default ICustomPredicateCopy<T> customAnd(ICustomPredicateCopy<T> other) {
        return arg -> this.isValid(arg) && other.isValid(arg);
    }
}

public class CustomPredicateCopy {


    public static void main(String[] args) {
        ICustomPredicateCopy<Integer> myPredicate = (n) -> n > 0;
        ICustomPredicateCopy<Integer> myPredicateCopy = (n) -> n % 2 == 0;

//        System.out.println(myPredicate.isValid(-1));
//        System.out.println(myPredicate.isValid(2));

        System.out.println(myPredicate.customAnd(myPredicateCopy).isValid(2));

    }
}

