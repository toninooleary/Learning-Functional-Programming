package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        int increment = increment(1);
        System.out.println("Incrementing non-functional output: " + increment);

        // apply() will apply the function to the passed value.
        int increment2 = incrementByOneFunction.apply(increment);
        System.out.println("Incrementing functional output: " + increment2);

        // This can be expressed as a bifunction. I show this below, as a static function
        Function<Integer, Integer> addBy1AndMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);

        System.out.println("andThen statement output: " + addBy1AndMultiplyBy10.apply(1));

        int value = incrementByOneAndMultiplyBiFunction.apply(1, 2);
        System.out.println("Bi-function output: " + value);

    }

    // This is the same as the static method below but in functional terms.
    // static lets allows it to be useable when declared outside of pvsm.
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    // It will take a number and increment it by 1
    static int increment(int number){
        return number + 1;
    }

    // This does the same thing as the static method below
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int multiplyBy){
        return (number + 1) * multiplyBy;
    }

}
